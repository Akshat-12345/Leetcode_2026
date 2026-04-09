class Solution {
    // public boolean isValid(int i ,int j ,int n){
    //     if(i >= 0 && i < n && j >= 0 && j < n){
    //        return true;
    //     }
    //     return false;
    // }

    // int [] cols = {-1 , 0 ,1};

    // public int minFallingPathSum(int[][] matrix) {
    //     int n = matrix.length;

    //     int [][] dp = new int [n][n];

    //     for(int i = 0 ; i < n ; i++){
    //         dp[0][i] = matrix[0][i];
    //     }

    //     for(int i = 1 ; i < n ; i++){
    //         for(int j = 0 ; j < n ; j++){
    //            int minVal = Integer.MAX_VALUE;
               
    //            for(int k = 0; k < 3 ; k++){
    //               int col = j + cols[k];
    //               if(isValid(i,col,n)){
    //                 minVal = Math.min(minVal,dp[i-1][col]);
    //               }
    //            }

    //            dp[i][j] = minVal + matrix[i][j];
    //         }
    //     }
        
    //     int minVal = Integer.MAX_VALUE;
    //     for(int i = 0 ; i < n ; i++){
    //         minVal = Math.min(minVal,dp[n-1][i]);
    //     }

    //     return minVal;
    // }


    Integer [][] dp;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        dp = new Integer[n][n];
        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < n ; j++){
           ans = Math.min(ans, solve(0 , j , matrix));
        }
        
        return ans;
    }

    public int solve(int i , int j , int [][] matrix){
        int n = matrix.length;
        if( j >= n || j < 0){
            return Integer.MAX_VALUE;
        }

        if(i == n - 1){
            return matrix[i][j];
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        return dp[i][j] = Math.min(solve(i + 1 , j - 1 , matrix), Math.min(solve( i + 1 , j , matrix), solve(i + 1 , j + 1 , matrix))) + matrix[i][j];
    }
}