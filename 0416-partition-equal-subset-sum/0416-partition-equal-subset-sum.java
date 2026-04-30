class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
        }

        if(sum % 2 == 1){
            return false;
        }
        
        int target = sum/ 2;

        boolean [][] dp = new boolean[n + 1][target + 1];

        for(int i = 0; i <= n ; i++){
            dp[i][0] = true;
        }

        for(int i = 1; i <= n ; i++){
            for(int j = 1 ; j <= target ; j++){
                int val = nums[i-1];
                if(j >= val){
                   dp[i][j] = dp[i-1][j] || dp[i - 1][j - val];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][target];
    }
}