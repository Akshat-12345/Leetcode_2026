class Solution {
    class pair{
        int from;
        int to;
        public pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    public int maximumMinutes(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean [][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        int [][] mat = new int [n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    mat[i][j] = -1;
                }
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    q.add(new pair(i,j));
                    vis[i][j] = true;
                }
            }
        }
        
        bfs(q,vis,grid,mat);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0 && vis[i][j] == false){
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
                
        int low = 0;
        int high = n*m;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, grid, mat)) {
                ans = mid;
                low = mid + 1;   // aur zyada wait kar sakte hain?
            } else {
                high = mid - 1;
            }
        }

        if(ans == n*m){
            return 1000000000;
        }
        return ans;
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public void bfs(Queue<pair> q, boolean [][] vis , int [][] grid , int[][] mat){
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;

        while(!q.isEmpty()){
            int s = q.size();
            time++;
            for(int i = 0 ; i < s ; i++){
                pair curr = q.remove();
                for(int k = 0 ; k < 4 ; k++){
                    int row = rows[k] + curr.from;
                    int col = cols[k] + curr.to;

                    if(row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 0 && vis[row][col] == false){
                        q.add(new pair(row,col));
                        vis[row][col] = true;
                        mat[row][col] = time;
                    }
                }
            }
        }
    }

    public boolean check(int wait, int[][] grid, int[][] mat) {
        int n = grid.length;
        int m = grid[0].length;

        if(mat[0][0] <= wait){
            return false;
        }
    
        Queue<pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
    
        q.add(new pair(0, 0));
        vis[0][0] = true;
    
        int time = wait;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
    
                pair curr = q.remove();
    
                if (curr.from == n - 1 && curr.to == m - 1) {
                    return true;
                }
    
                for (int k = 0; k < 4; k++) {

                   int nr = curr.from + rows[k];
                   int nc = curr.to + cols[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0 && !vis[nr][nc]) {
                        int arrival = time + 1;
                        // Destination
                        if (nr == n - 1 && nc == m - 1) {              
                            if (arrival <= mat[nr][nc]) {
                                vis[nr][nc] = true;
                                q.add(new pair(nr, nc));
                            }
                        } else {        
                            // Normal cell
                            if (arrival < mat[nr][nc]) {
                                vis[nr][nc] = true;
                                q.add(new pair(nr, nc));
                            }
                        }
                    }
                }                
            }
            time++;
        }

        return false;
    }
}