class Solution {
    static class DSU{
        int[] parent;
        int[] rank;
        int[] size;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            size = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY){
                return;
            }
            
            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
            }
            else if(rank[parentX] <  rank[parentY]){
                parent[parentX] = parentY;
                size[parentY] += size[parentX];
            }else{
                parent[parentY] = parentX;
                size[parentX] += size[parentY];
                rank[parentX]++;
            }
            
        }
    }

    public int countServers(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        DSU d = new DSU(m*n);

        for(int i = 0 ; i < n ; i++){
            int prevIdx = -1;
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    int newIdx = i*m + j;
                    if(prevIdx != -1){
                       d.union(prevIdx,newIdx);
                    }
                    prevIdx = newIdx;
                }
               
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            int prevIdx = -1;
            for(int j = 0 ; j < n ; j++){
               if(grid[j][i] == 1){
                    int newIdx = j*m + i;
                    if(prevIdx != -1){
                       d.union(prevIdx,newIdx);
                    }
                    prevIdx = newIdx;
               }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                int id = i * m + j;
                int root = d.find(id);
                if(d.size[root] > 1){
                    count ++;
                }
            }
        }

        return count;
    }
}