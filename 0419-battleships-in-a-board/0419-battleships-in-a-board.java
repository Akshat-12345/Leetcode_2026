class Solution {
    class pair{
        int from;
        int to;
        public pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];

        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
               if(board[i][j] == 'X' && vis[i][j] == false){
                  bfs(i,j,vis,board);
                  count++;
               }
            }
        }

        return count;
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public void bfs(int i , int j , boolean [][] vis, char [][] board){
        int n = board.length;
        int m = board[0].length;

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j] = true;

        while(!q.isEmpty()){
           pair curr = q.remove();
           int currRow = curr.from;
           int currCol = curr.to;

           for(int k = 0 ; k < 4 ; k++){
              int row = currRow + rows[k];
              int col = currCol + cols[k];

              if(row >= 0 && row < n && col >= 0 && col < m && board[row][col] == 'X' && vis[row][col] == false){
                   q.add(new pair(row,col));
                   vis[row][col] = true;
              }
           }
        }
    }
}