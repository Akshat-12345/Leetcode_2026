class Solution {
    class pair {
        int to;
        int wt;
        int time;
        pair(int to, int wt, int time) {
            this.to = to;
            this.wt = wt;
            this.time = time;
        }
    }

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new pair(v, w,0));
            adj.get(v).add(new pair(u, w,0));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        int [][] prices = new int [n][maxTime + 1];

        for(int i = 0 ; i < prices.length ; i++){
            Arrays.fill(prices[i],Integer.MAX_VALUE);
        }

        prices[0][0] = passingFees[0];
        pq.add(new pair(0,passingFees[0],0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int node = curr.to;
            int currPrice = curr.wt;
            int currTime = curr.time;

            if (currTime > maxTime) continue;

            for (pair x : adj.get(node)) {
               int calcTime = currTime + x.wt;
               int calcPrice = currPrice + passingFees[x.to];
               if(calcTime <= maxTime && calcPrice < prices[x.to][calcTime]){
                  prices[x.to][calcTime] =calcPrice;
                  pq.add(new pair(x.to,calcPrice,calcTime));
               }                 
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < maxTime + 1; i++) {
            ans = Math.min(ans, prices[n-1][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}