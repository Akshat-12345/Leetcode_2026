class Solution {
    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY){
                return false;
            }
            
            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }
            else if(rank[parentX] <  rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            
            return true;
        }
    }

    public int minCost(int n, int[][] edges, int k) {
        int m = edges.length;
        Arrays.sort(edges,Comparator.comparingInt(o -> o[2]));

        DSU d = new DSU(n);
        int maxEdge = 0;
        int edgesUsed = 0;
        for(int i = 0; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];          

            if(d.union(u,v)){
               if(edgesUsed == n - k) break;
               maxEdge = Math.max(maxEdge, w);
               
               edgesUsed++;
            }
                       
        }

        return maxEdge;
    }
}