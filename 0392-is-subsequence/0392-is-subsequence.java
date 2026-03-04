class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();

        if(m > n){
            return false;
        }

        int [][] dp = new int [n+1][m+1];

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < m+ 1; j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if(dp[n][m] == m){
            return true;
        }

        return false;
    }
}