class Solution {
    int MOD = 1_000_000_007;
    class pair {
        int to;
        long wt;
        pair(int to, long wt) {
            this.to = to;
            this.wt = wt;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }

         PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));

        long[] dist = new long[n];
        int[] ways = new int[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new pair(0,0));

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int node = curr.to;
            long currTime = curr.wt;

            if (currTime > dist[node]) continue;

            for (pair x : adj.get(node)) {
                if (dist[x.to] > currTime + x.wt) {
                    dist[x.to] = currTime + x.wt;
                    ways[x.to] = ways[node];
                    pq.add(new pair(x.to, (long)dist[x.to]));
                }else if(dist[x.to] == currTime + x.wt){
                    ways[x.to] = (ways[x.to] + ways[node])%MOD;
                }

            }
        }

        return ways[n-1];

    }
}