class Solution {
    int dp [];
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int [n+1];
        Arrays.fill(dp,-1);

        int l = solve(1,n , cost);
        int r = solve(0,n, cost);

        return Math.min(dp[0],dp[1]);
    }

    public int solve(int i , int n , int [] cost){
        if(i >= n){
            return 0;
        }
        
        if(dp[i] != -1) return dp[i];

        return dp[i] = Math.min(solve(i + 1, n, cost), solve(i + 2 ,n, cost)) + cost[i];
    }
} 