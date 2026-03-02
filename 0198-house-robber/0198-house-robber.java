class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp,-1);

        return solve(0,nums,dp);
    }

    public int solve(int i , int [] nums , int [] dp){
        int n = nums.length;
        if(i >= n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(i + 2, nums, dp);
        int notTake = solve(i + 1, nums, dp);

        return dp[i] = Math.max(take,notTake);
    }
    
    
}