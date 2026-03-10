class Solution {
    class DSU{
        int [] parent;
        int [] rank;
        int components;

        public DSU(int n){
            parent = new int[n];
            rank = new int[n];
            components = n;

            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }

            return parent[x] = find(parent[x]);
        }

        public void union(int x , int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX == parentY){
                return;
            }

            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }else if(rank[parentX] < rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }

            components--;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int m = connections.length;
        DSU d = new DSU(n);
        if(m < n - 1){
            return -1;
        }

        for(int i = 0 ; i < m ; i++){
            d.union(connections[i][0], connections[i][1]);
        }

        return d.components - 1;
    }
}