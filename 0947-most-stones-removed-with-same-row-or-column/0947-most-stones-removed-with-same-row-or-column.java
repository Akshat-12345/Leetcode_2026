class Solution {
    class DSU{
        int parent [];
        int rank [];
        int components = 0;

        public DSU(int n){
            parent = new int[n];
            rank = new int [n];
            components = n;

            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find (int x ){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x , int y){

            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY) return;

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

    public int removeStones(int[][] stones) {
        int n = stones.length;
        DSU d = new DSU(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int u = stones[i][0];
                int v = stones[i][1];
     
                int prevU = stones[j][0];
                int prevV = stones[j][1];
     
                if( u == prevU || v == prevV){
                   d.union(i,j);
                }
            }          
        }

        return n - d.components;
    }
}