class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n+1][2];
        dp[0][0] = prices[0];
        dp[0][1] = 0;

        for(int i = 1 ; i <= n ; i++){
           int buyPrice = prices[i-1];
           dp[i][0] = Math.min(dp[i-1][0],buyPrice);
           dp[i][1] = Math.max(dp[i-1][1],buyPrice - dp[i][0]);
        }

        return dp[n][1];
    }
}