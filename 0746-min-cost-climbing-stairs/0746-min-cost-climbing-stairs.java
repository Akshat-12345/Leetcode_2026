class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int [] dp = new int [cost.length];
        // Arrays.fill(dp,-1);
        // int m = Math.min(solve(cost , 0 , dp),solve(cost , 1 , dp));
        // return m;

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2 ; i < cost.length ; i++){
            int val = cost[i];
            dp[i] = val + Math.min(dp[i-1] , dp[i-2]);
        }

        return Math.min(dp[n-1],dp[n-2]);
    }

    // public int solve(int [] cost, int i , int [] dp){
    //      if( i >= cost.length){
    //         return 0;
    //      }

    //      if(dp[i] != -1){
    //         return dp[i];
    //      }

    //      int n =  cost[i] + solve(cost,i+1,dp);
    //      int n1 = cost[i] + solve(cost,i+2,dp);

    //      return dp[i] = Math.min(n,n1);
    // }
}