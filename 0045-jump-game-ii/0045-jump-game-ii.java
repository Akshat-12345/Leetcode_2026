class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp,-1);
        int i = 0;
        return solve(i , nums , dp);
    }

    public int solve(int i , int [] nums , int [] dp){
        if(i >= nums.length){
            return Integer.MAX_VALUE;
        }

        if(i == nums.length - 1){
            return 0;
        }

        if (nums[i] == 0) return Integer.MAX_VALUE;

        if(dp[i] != -1){
            return dp[i];
        }
        
        int ans = Integer.MAX_VALUE;
        for(int j = 1 ; j <= nums[i] ; j++){
            int next = solve(i + j , nums , dp);
            if(next != Integer.MAX_VALUE){
               ans = Math.min(ans,1 + next);
            }
        }

        return dp[i] = ans;


    }
}