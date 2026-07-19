class Solution {
    class pair{
        int from;
        int to;
        public pair(int from , int to){
            this.from = from;
            this.to = to;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();

        boolean fresh = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 2){
                    q.add(new pair(i,j));
                    vis[i][j] = true;
                }

                if(grid[i][j] == 1){
                    fresh = true;
                }
            }
        }

        if(fresh == false){
            return 0;
        }

        int t = bfs(q, vis, grid);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return t;
    }

    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int bfs(Queue<pair> q , boolean[][] vis, int [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int t = -1;

        while(!q.isEmpty()){
            int s = q.size();
            t++;
            for(int i = 0 ; i < s ; i++){
                pair curr = q.remove();
                int currRow = curr.from;
                int currCol = curr.to;

                for(int k = 0 ; k < 4 ; k++){
                    int row = currRow + rows[k];
                    int col = currCol + cols[k];

                    if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && vis[row][col] == false){
                        vis[row][col] = true;
                        q.add(new pair(row,col));
                        grid[row][col] = 2;
                    }
                }
            }
        }

        return t;
    }
}