class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n+1];
        // Arrays.fill(dp,-1);

        // return solve(0,nums,dp);
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2 ; i <= n ; i++){
            int val = nums[i-1];
            dp[i] = Math.max(dp[i-1],dp[i-2] + val);
        }

        return dp[n];

        
    }

    // public int solve(int i , int [] nums , int [] dp){
    //     int n = nums.length;
    //     if(i >= n){
    //         return 0;
    //     }

    //     if(dp[i] != -1){
    //         return dp[i];
    //     }

    //     int take = nums[i] + solve(i + 2, nums, dp);
    //     int notTake = solve(i + 1, nums, dp);

    //     return dp[i] = Math.max(take,notTake);
    // }
    
    
}