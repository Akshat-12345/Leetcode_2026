class Solution {
    class pair{
        int to;
        int wt;
        public pair(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }

    public int networkDelayTime(int[][] edges, int V, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
        for(int i = 0; i < V ; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length ; i++){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            int w = edges[i][2];
            
            adj.get(u).add(new pair(v,w));
        }
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new pair(k-1,0));
        int [] distance = new int[V];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[k-1] = 0;

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int node = curr.to;
            int dist = curr.wt;
            
            
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                pair x = adj.get(node).get(i);
                if(distance[x.to] == Integer.MAX_VALUE || distance[x.to] > x.wt + dist){
                    distance[x.to] = x.wt + dist;
                    pq.add(new pair(x.to,distance[x.to]));
                }
            }
        }
        int maxTime = 0;
        for(int i = 0 ; i < distance.length ; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }else{
                maxTime = Math.max(maxTime,distance[i]);
            }
        }

        return maxTime;
    }
}