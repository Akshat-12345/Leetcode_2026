class Solution {
    class DSU{
        int [] parent;
        public DSU(int n){
            parent = new int [n];
            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public boolean union(int x , int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX != parentY){
                parent[parentY] = parentX;
            }

            if(parentX == parentY){
                return true;
            }

            return false;
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }

            return parent[x] = find(parent[x]);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int [] arr = new int [2];

        DSU d = new DSU(n+1);
        
        for(int i = 0 ; i < n; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            if(d.union(u,v)){
                arr[0] = u;
                arr[1] = v;
                break;
            }
        }

        return arr;
    }
}