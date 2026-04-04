class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long [][] dp = new long [n + 1][2];

        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int i = 1 ; i < n + 1 ; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i -1][1] + nums[i - 1]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i -1][0] - nums[i - 1]);
        } 

        return dp[n][0];
    }
} 