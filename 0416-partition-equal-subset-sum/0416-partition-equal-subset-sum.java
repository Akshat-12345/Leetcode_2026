class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0 ; 
        for(int num : nums){
            sum += num;
        }
        
        if(sum % 2 == 1){
            return false;
        }

        boolean [][] dp = new boolean [n + 1][sum/2 + 1];
        
        for(int i = 0 ; i <= n ;i++){
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= sum/2 ; j++){
                int val = nums[i-1];
                if(val <= j && dp[i-1][j - val] == true){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum/2];
    }
}