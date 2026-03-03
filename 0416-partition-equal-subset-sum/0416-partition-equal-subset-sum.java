class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        int n = nums.length;
        for(int i = 0 ; i < n ;i++){
            totalSum += nums[i];
        }

        if(totalSum % 2 == 1){
            return false;
        }

        int target = totalSum/2;

        boolean [][] dp = new boolean [n + 1][target + 1];

        for(int i = 0 ; i < n + 1 ; i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                int val = nums[i-1];
                if(val <= j && dp[i-1][j-val] == true){
                    dp[i][j] = true;
                }else if(dp[i-1][j] == true){
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][target];
    }
}