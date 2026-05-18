class Solution {
    public class pair{
        int from;
        int to;
        int color;
        public pair(int from, int to , int color){
            this.from = from;
            this.to = to;
            this.color = color;

        }
    }

    int [] rows = {-1 ,1, 0 , 0};
    int [] cols = {0, 0 , -1 , 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean [][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(sr,sc,image[sr][sc]));
        image[sr][sc] = color;
        vis[sr][sc] = true;

        while(!q.isEmpty()){
            pair node = q.remove();

            for(int i = 0 ; i < 4 ; i++){
                int row = rows[i] + node.from;
                int col = cols[i] + node.to;

                if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == false && image[row][col] == node.color ){
                    q.add(new pair(row,col,image[row][col]));
                    vis[row][col] = true;
                    image[row][col] = color;
                }
            }
        }

        return image;
    }
}