class Solution {
    class pair {
        int to;
        int wt;
        int stop;
        pair(int to, int wt, int stop) {
            this.to = to;
            this.wt = wt;
            this.stop = stop;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w =flights[i][2];

            adj.get(u).add(new pair(v, w,0));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);

        int [][] prices = new int [n][k+2];
        for(int i = 0 ; i < prices.length ; i++){
            Arrays.fill(prices[i],Integer.MAX_VALUE);
        }

        prices[src][0] = 0;
        pq.add(new pair(src,0,0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int node = curr.to;
            int currPrice = curr.wt;
            int currStop = curr.stop;

            if (currStop > k) continue;

            for (pair x : adj.get(node)) {

                if (prices[x.to][currStop + 1] > currPrice + x.wt) {
                    prices[x.to][currStop + 1] = currPrice + x.wt;
                    pq.add(new pair(x.to, currPrice + x.wt, currStop + 1));
                }                
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= k + 1; i++) {
            ans = Math.min(ans, prices[dst][i]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}