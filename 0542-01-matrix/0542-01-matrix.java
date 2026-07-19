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

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        boolean [][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new pair(i,j));
                    vis[i][j] = true;
                }
            }
        }

        bfs(q,vis,mat);

        return mat;
    }

    public void bfs(Queue<pair> q , boolean [][] vis , int [][] mat){
         int n = mat.length;
         int m = mat[0].length;
         int dist = 0;

         while(!q.isEmpty()){
            int s = q.size();
            dist++;
            for(int i = 0 ; i < s ; i++){
                pair curr = q.remove();

                for(int k = 0 ; k < 4 ; k++){
                    int row = rows[k] + curr.from;
                    int col = cols[k] + curr.to;

                    if(row >= 0 && row < n && col >= 0 && col < m && mat[row][col] == 1 && vis[row][col] == false){
                        vis[row][col] = true;
                        mat[row][col] = dist;
                        q.add(new pair(row,col));
                    }
                }
            }
         }
    }
}