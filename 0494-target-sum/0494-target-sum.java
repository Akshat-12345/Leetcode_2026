class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][4001];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        int m = solve(nums,target, 0, 0,dp);
        return m;
    }
    
     public int solve(int[] nums, int target, int i , int sum, int[][] dp){
        if( i == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        
        if (dp[i][sum + 2000] != -1) {
            return dp[i][sum + 2000];
        }

        int plus = 0; 
        int minus = 0;
        plus = solve(nums,target, i + 1, sum + nums[i],dp);
        minus = solve(nums,target, i + 1, sum - nums[i],dp);
        
        return dp[i][sum + 2000] = plus + minus;
     }
}