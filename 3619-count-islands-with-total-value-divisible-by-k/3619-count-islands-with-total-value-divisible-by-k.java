class Solution {
    class pair{
        int from;
        int to;
        public pair(int from , int to){
            this.from = from;
            this.to = to;
        }
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int count = 0;

        for(int i = 0; i < n ; i++){
           for(int j = 0 ; j < m ; j++){
               if(grid[i][j] != 0 && vis[i][j] == false){
                   long val = bfs(i,j,vis,grid);
                   if(val % k == 0){
                     count++;
                   }
               }
           }
        }

        return count;
    }

    public long bfs(int i , int j , boolean [][] vis , int [][] grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j] = true;
        long sum = 0;
        
        while(!q.isEmpty()){
            pair curr = q.remove();
            int currRow = curr.from;
            int currCol = curr.to;

            sum += grid[currRow][currCol];

            for(int k = 0 ; k  < 4 ; k++){
                int row = currRow + rows[k];
                int col = currCol + cols[k];

                if(row < n && row >= 0 && col < m && col >= 0 && grid[row][col] != 0 && vis[row][col] == false){
                    q.add(new pair(row,col));
                    vis[row][col] = true;
                }
            }
        }

        return sum;
    }

}