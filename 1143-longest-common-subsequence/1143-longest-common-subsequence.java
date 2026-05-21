class Solution {
    Integer [][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new Integer[n+1][m+1];
        return solve(0,0,text1,text2);
    }
    public int solve(int i , int j , String text1, String text2){
        int n = text1.length();
        int m = text2.length();
        if(i == n || j == m){
            return 0 ;
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }
        
        int take = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            take = 1  + solve(i+1,j+1,text1,text2);
        }

        int Iinc = solve(i+1,j,text1,text2);
        int Jinc = solve(i,j+1,text1,text2);

        return dp[i][j] = Math.max(Iinc,Math.max(Jinc,take));
    }
}