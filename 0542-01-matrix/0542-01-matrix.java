class Solution {
    public class pair{
        int from;
        int to;
        public pair(int from, int to ){
            this.from = from;
            this.to = to;
        }
    }

    int [] rows = {-1 ,1, 0 , 0};
    int [] cols = {0, 0 , -1 , 1};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue q = new LinkedList<>();
        boolean [][] vis = new boolean[n][m];
        int[][] arr = new int [n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    q.add(new pair(i,j));
                    vis[i][j] = true;
                }
            }
        }

        bfs(q,vis,mat,arr);
        return arr;
    }

    public void bfs(Queue<pair> q , boolean [][] vis, int [][] mat, int [][] arr){
        int n = mat.length;
        int m = mat[0].length;
        int dist  = 0;
        while(!q.isEmpty()){
            int size = q.size();
            dist++;
            while(size > 0){
                pair curr = q.remove();

                for(int i = 0 ; i < 4 ; i++){
                    int currRow = rows[i] + curr.from;
                    int currCol = cols[i] + curr.to;

                    if(currRow >= 0 && currRow < n && currCol >= 0 && currCol < m && vis[currRow][currCol] == false && mat[currRow][currCol] != 0){
                        q.add(new pair(currRow,currCol));
                        vis[currRow][currCol] = true;
                        arr[currRow][currCol] = dist;
                    }
                }
                size--;
            }
        }
    }
}