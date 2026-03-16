class Solution {
    class pair{
        int from;
        int to;
        public pair(int from, int to){
            this.from = from;
            this.to = to;
        }
    }

    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        boolean [][] vis = new boolean[n][m];
        ArrayList<ArrayList<Integer>> ans  = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < m ; j++){
                if(land[i][j] == 1 && vis[i][j] == false){
                    ArrayList<Integer> arr = bfs(i,j,vis,land);
                    ans.add(arr);
                }
            }
        }

        int row = ans.size();
        int [][] sol = new int [row][4];

        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 4 ; j++){
                sol[i][j] = ans.get(i).get(j);
            }
        }
        
        return sol;
    }
    
    int [] rows = {-1, 1, 0 , 0};
    int [] cols = {0 , 0 ,-1, 1};

    public ArrayList<Integer> bfs(int i , int j , boolean [][] vis, int [][] land){
        int n = land.length;
        int m = land[0].length;
        Queue<pair> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(i);
        arr.add(j);

        q.add(new pair(i,j));
        vis[i][j] = true;
      
        int maxRow  = i;
        int maxCol = j;

        while(!q.isEmpty()){
            pair curr = q.remove();
            int currRow = curr.from;
            int currCol = curr.to;

            for(int k = 0 ; k  < 4 ; k++){
                int row = rows[k] + currRow;
                int col = cols[k] + currCol;

                if(row >= 0 && row < n && col >= 0 && col < m && land[row][col] == 1 && vis[row][col] == false){
                    q.add(new pair(row,col));
                    vis[row][col] = true;
                    maxRow = Math.max(maxRow, row);
                    maxCol = Math.max(maxCol, col);
                }
            }

        }

        arr.add(maxRow);
        arr.add(maxCol);
        
        return arr;
    }
}