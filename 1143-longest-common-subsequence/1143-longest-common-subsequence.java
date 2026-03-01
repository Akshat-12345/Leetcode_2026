class Solution {
    public int longestCommonSubsequence(String t1, String t2) {
        int s = t1.length();
        int t = t2.length();
        int [][] dp = new int [s+1][t+1];
        // for(int i = 0 ; i < dp.length ; i ++){
        //     Arrays.fill(dp[i],-1);
        // }
        // int m = back(t1,t2,s-1,t-1,dp);

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++ ){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s][t];
    }
    // public int solve(String t1 , String t2 , int i , int j,int [][] dp){
    //     if(i == t1.length() || j == t2.length()){
    //         return 0;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     if( t1.charAt(i) == t2.charAt(j)){
    //         return dp[i][j] = 1 + solve(t1,t2, i + 1, j+1,dp);
    //     }

    //     int iIncreament = solve(t1,t2,i+1,j,dp);
    //     int jIncreament = solve(t1,t2,i,j+1,dp);
    //     return dp[i][j] = Math.max(iIncreament,jIncreament);
    // }

    // public int back(String t1 , String t2 , int i , int j,int [][] dp){
    //     if(i < 0 || j < 0){
    //         return 0;
    //     }
    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
    //     if( t1.charAt(i) == t2.charAt(j)){
    //         return dp[i][j] = 1 + back(t1,t2, i - 1, j-1,dp);
    //     }

    //     int iIncreament = back(t1,t2,i-1,j,dp);
    //     int jIncreament = back(t1,t2,i,j-1,dp);
    //     return dp[i][j] = Math.max(iIncreament,jIncreament);
    // }
}