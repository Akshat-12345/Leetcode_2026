class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][] dp = new int [n + 1][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;

        for(int i = 1 ; i <= prices.length ; i++){
            int currVal = prices[i-1];

            dp[i][0] = Math.max(dp[i-1][0] , dp[i-1][1] - currVal);
            dp[i][1] = Math.max(dp[i-1][1] , dp[i-1][0] + currVal);
        }

        return dp[n][1];
    }
}