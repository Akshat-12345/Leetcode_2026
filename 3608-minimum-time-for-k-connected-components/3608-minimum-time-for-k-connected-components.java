class Solution {
    class DSU{
        int [] parent;
        int [] rank;
        int component = 0;
        public DSU(int n){
            parent = new int [n];
            rank = new int [n];
            component = n;
            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int pX = find(x);
            int pY = find(y);
            
            if(pX == pY){
                return;
            }

            if(rank[pX] > rank[pY]){
                parent[pY] = pX;
            }else if(rank[pY] > rank[pX]){
                parent[pX] = pY;
            }else{
                parent[pY] = pX;
                rank[pX]++;
            }
            component--;
        }

    }
    public int minTime(int n, int[][] edges, int k) {
        DSU d = new DSU(n);
        int m = edges.length;
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));

        for (int i = m - 1; i >= 0; i--) {
            d.union(edges[i][0], edges[i][1]);

            if (d.component < k) {
                return edges[i][2];
            }
        }



        return 0;
    }
}