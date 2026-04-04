class Solution {
    // public long maxAlternatingSum(int[] nums) {
    //     int n = nums.length;
    //     long [][] dp = new long [n + 1][2];

    //     dp[0][0] = 0;
    //     dp[0][1] = 0;

    //     for(int i = 1 ; i < n + 1 ; i++){
    //         dp[i][0] = Math.max(dp[i-1][0], dp[i -1][1] + nums[i - 1]);
    //         dp[i][1] = Math.max(dp[i-1][1], dp[i -1][0] - nums[i - 1]);
    //     } 

    //     return dp[n][0];
    // }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        
        long [][] dp = new long [n + 1][2];
        for (int i = 0; i <= n; i++) {
           Arrays.fill(dp[i], -1);
        }

        return solve(0 , 0 , nums , dp);
    }

    public long solve(int i , int state , int [] nums , long [][] dp){
        int n = nums.length;

        if(i == n){
            return 0;
        }

        if(dp[i][state] != -1){
            return dp[i][state];
        }

        if(state == 0){
            return dp[i][state] = Math.max(solve(i + 1, 1 , nums , dp) + nums[i] , solve(i + 1, 0 , nums , dp));
        }else{
            return dp[i][state] = Math.max(solve(i + 1, 0 , nums , dp) - nums[i] , solve(i + 1, 1, nums , dp));
        }
    }
} 