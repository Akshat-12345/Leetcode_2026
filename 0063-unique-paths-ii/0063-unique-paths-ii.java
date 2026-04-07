class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int [n][m];
        
        boolean foundObs = false;
        for(int i = 0 ; i< n ; i++){
            if(grid[i][0] == 1){
                dp[i][0] = 0;
                foundObs = true;
            }else if (foundObs){
                dp[i][0] = 0;
            }else{
                dp[i][0] = 1;
            }
        }

        boolean foundCol = false;
        for(int i = 0 ; i < m ; i++){
            if(grid[0][i] == 1){
                dp[0][i] = 0;
                foundCol = true;
            }else if (foundCol){
                dp[0][i] = 0;
            }else{
                dp[0][i] = 1;
            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < m ; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}