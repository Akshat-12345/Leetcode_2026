class Solution {
    static class DSU{
        int[] parent;
        int[] rank;
        int components = 0;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            components = n;
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
            components--;
            return true;
            
        }
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU d = new DSU(n);
        DSU t = new DSU(n);

        int count = 0;

        for(int i = 0 ; i < edges.length ; i++){
            int w = edges[i][0];
            int u = edges[i][1]-1;
            int v = edges[i][2]-1;

            if(w == 3){

                boolean a = d.union(u,v);
                boolean b = t.union(u,v);

                if(!a && !b) count++;
            }

        }

        for(int i = 0 ; i < edges.length ; i++){
            int w = edges[i][0];
            int u = edges[i][1]-1;
            int v = edges[i][2]-1;

            if(w == 1){

                if(!d.union(u,v)){
                    count++;
                }
            }

            if(w == 2){

                if(!t.union(u,v)){
                    count++;
                }
            }
        }
        
        if(d.components != 1 || t.components != 1) return -1;

        return count;
    }
}