class Solution {
    public boolean isValid(int i ,int j ,int n){
        if(i >= 0 && i < n && j >= 0 && j < n){
           return true;
        }
        return false;
    }

    int [] cols = {-1 , 0 ,1};

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int [][] dp = new int [n][n];

        for(int i = 0 ; i < n ; i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
               int minVal = Integer.MAX_VALUE;
               
               for(int k = 0; k < 3 ; k++){
                  int col = j + cols[k];
                  if(isValid(i,col,n)){
                    minVal = Math.min(minVal,dp[i-1][col]);
                  }
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