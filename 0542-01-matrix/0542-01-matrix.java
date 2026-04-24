class Solution {
    class pair{
        int from;
        int to;
        public pair(int from, int to){
            this.from = from;
            this.to=to;
        }
    }

    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<pair> q = new LinkedList<>();
        int [][] arr = new int [n][m];
        boolean [][] vis = new boolean[n][m];

        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new pair(i,j));
                    vis[i][j] = true;
                    arr[i][j] = 0;
                }
            }
        }
        
        bfs(mat,arr,q,vis);

        return arr;
    }

    public void bfs(int [][] mat, int [][] arr , Queue<pair> q , boolean[][] vis){
        int n = mat.length;
        int m = mat[0].length;
        int dist = 0;

        while(!q.isEmpty()){
            int size = q.size();
            dist++;

            while(size > 0){
                pair curr = q.remove();
                for(int k = 0 ; k < 4 ; k++){

                    int row = curr.from + rows[k];
                    int col = curr.to + cols[k];
     
                    if(row >= 0 && row < n && col >= 0 && col < m && mat[row][col] == 1 && vis[row][col] == false){
                        q.add(new pair(row,col));
                        vis[row][col] = true;
                        arr[row][col] = dist;
                    }
                }
                size--;
            }
           
        }
    }
}