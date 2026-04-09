class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int [][] dp = new int [n][n];

        for(int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
               int minVal = Integer.MAX_VALUE;
               for(int k = 0 ; k < n ; k++){
                 if( j == k){
                    continue;
                 }
                 minVal = Math.min(minVal , dp[i-1][k]);
               }
               dp[i][j] = minVal + matrix[i][j];
            }
        }
        
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            minVal = Math.min(minVal,dp[n-1][i]);
        }

        return minVal;
    }

}