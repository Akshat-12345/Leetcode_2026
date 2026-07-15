class Solution {
    class pair{
        int from;
        int to;
        public pair(int from , int to){
            this.from = from;
            this.to = to;
        }
    }

    public int numIslands (char [][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;

        boolean [][] vis = new boolean[n][m];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(isConnected[i][j] == '1' && vis[i][j] == false){
                    bfs(i,j,vis,isConnected);
                    count++;
                }
            }
        }

        return count;
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public void bfs(int i , int j , boolean[][] vis , char [][] grid){
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> q = new LinkedList<>();

        q.add(new pair(i,j));
        vis[i][j] = true;

        while(!q.isEmpty()){
            pair curr = q.remove();
            
            for(int k = 0; k < 4 ; k++){
                int currRow = curr.from + rows[k];
                int currCol = curr.to + cols[k];

                if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && grid[currRow][currCol] == '1' && vis[currRow][currCol] == false){
                    q.add(new pair(currRow,currCol));
                    vis[currRow][currCol] = true;
                }
            }
        }

    }
}