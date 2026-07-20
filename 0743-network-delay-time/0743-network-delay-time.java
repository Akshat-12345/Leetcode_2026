class Solution {
    class pair{
        int node;
        int wt;
        public pair(int node , int wt){
            this.node = node;
            this.wt = wt;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int s = times.length;
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for(int i = 0 ; i < n + 1 ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < s ; i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            adj.get(u).add(new pair(v,w));
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        int [] dist = new int [n + 1];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;

        pq.add(new pair(k,0));

        while(!pq.isEmpty()){
            pair curr = pq.poll();

            for(int i = 0; i < adj.get(curr.node).size(); i++){
                pair newNode = adj.get(curr.node).get(i);
                int node = newNode.node;
                int d = newNode.wt;

                if(curr.wt + d < dist[node]){
                    dist[node] = curr.wt + d;
                    pq.add(new pair(node,dist[node]));
                }
            }
        }

        int mt  = 0;
        for(int i = 1 ; i < n + 1; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                mt = Math.max(mt, dist[i]);
            }
        }

        return mt;
    }
}