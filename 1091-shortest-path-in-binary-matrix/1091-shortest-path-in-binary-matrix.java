class Solution {
    class pair{
        int from;
        int to;
        public pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1){
            return -1;
        }

        boolean [][] vis = new boolean[n][m];
        int [][] maxDist = new int [n][m];
        maxDist[0][0] = 1;
        int dist = bfs(0,0,grid,vis,maxDist);

        return dist;
    }
    
    int [] rows = {-1,1,0,0,1,-1,1,-1};
    int [] cols = {0,0,-1,1,1,-1,-1,1};

    public int bfs(int i , int j , int [][] grid, boolean [][] vis, int [][] maxDist){
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i,j));
        vis[i][j] = true;

        while(!q.isEmpty()){
            
                pair curr = q.remove();
                if(curr.from == n-1 && curr.to == m-1){
                    return maxDist[n-1][m-1];
                }

                for(int k = 0 ; k < 8 ; k++){
                    int row = curr.from + rows[k];
                    int col = curr.to + cols[k];

                    if(row >= 0 &&  row < n && col >= 0 && col < m && vis[row][col] == false && grid[row][col] == 0){
                        vis[row][col] = true;
                        q.add(new pair(row,col));
                        maxDist[row][col] = maxDist[curr.from][curr.to] + 1;
                    }
                    
                }
                
        }

        return -1;
    }
}