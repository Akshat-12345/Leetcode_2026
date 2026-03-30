class Solution {
    int dp [];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        dp = new int [n+1];
        Arrays.fill(dp,-1);
        return Math.min(solve(n , cost),solve(n-1,cost)) ;
    }

    public int solve(int n , int [] cost){
        if(n == 0 || n == 1){
            return cost[n];
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = Math.min(solve(n - 1, cost), solve(n-2, cost)) + cost[n];
    }
} 