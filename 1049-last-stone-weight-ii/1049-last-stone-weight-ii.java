class Solution {
    Integer[][] dp;

    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0; 
        int n = stones.length;

        for(int i = 0 ; i < n ; i++){
            sum += stones[i];
        }

        int target = sum/2;

        dp = new Integer[stones.length][target+1];
        int S1 = solve(stones, target, 0);
        int S2 = sum-S1;

        return Math.abs(S1-S2);
    }

    public int solve(int[] nums, int target, int i){

        if(i>=nums.length){
            return target>=0? 0 : Integer.MIN_VALUE;
        }

        if(dp[i][target] != null){
           return dp[i][target];
        } 

        int take = Integer.MIN_VALUE;

        if(target-nums[i]>=0){
            take = nums[i] + solve(nums, target-nums[i], i+1);
        }
        int notTake = solve(nums, target, i+1);

        int ans = Math.max(take, notTake);
        return dp[i][target] = ans;
    }
}