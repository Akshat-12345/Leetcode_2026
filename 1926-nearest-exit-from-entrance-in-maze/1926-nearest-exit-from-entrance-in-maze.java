class Solution {
    class pair{
        int from;
        int to;
        int wt;
        public pair(int from, int to, int wt){
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int rowStart = entrance[0];
        int colStart = entrance[1];

        Queue<pair> q = new LinkedList<>();
        boolean [][] vis = new boolean[n][m];

        q.add(new pair(rowStart, colStart, 0));
        vis[rowStart][colStart] = true;
        
        while(!q.isEmpty()){
           pair curr = q.remove();
           int currRow = curr.from;
           int currCol = curr.to;
           int currSteps = curr.wt;

           if((currRow == 0 || currRow == n-1 || currCol == m-1 || currCol == 0) && !(currRow == rowStart && currCol == colStart)){
              return currSteps;
           }

           for(int i = 0 ; i < 4; i++){
             int row = currRow + rows[i];
             int col = currCol + cols[i];

             if(row >= 0 && row < n && col >= 0 && col < m && maze[row][col] == '.' && vis[row][col] == false){
                vis[row][col] = true;
                q.add(new pair(row,col,currSteps + 1));
             }
           }
        }

        return -1;
    }
}  