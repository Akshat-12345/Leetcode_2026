class Solution {

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp =new int[n][m];

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                int val = dfs(i,j,matrix,dp);
                ans = Math.max(ans,val);
            }
        }

        return ans;
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int dfs(int i , int j , int [][] matrix, int [][] dp){
        int n = matrix.length;
        int m = matrix[0].length;

        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        int max = 1;

        for(int k = 0 ; k < 4 ; k++){
            int row = i + rows[k];
            int col = j + cols[k];

            if(row >= 0 && row < n && col >= 0 && col < m && matrix[i][j] < matrix[row][col]){
                max = Math.max(max, 1 + dfs(row,col,matrix,dp));
            }
        }

        return dp[i][j] = max;

    }
}