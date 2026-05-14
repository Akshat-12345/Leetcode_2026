class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [][] dp = new int [n + 1][n + 1];

        for(int i = n - 1 ; i >= 0 ; i--){
            for(int j = i -1 ; j >= -1 ; j--){
                int take = 0;
                if( j == -1 || nums[i] > nums[j] ){
                    take = 1 + dp[i + 1][i + 1];
                }
                int notTake = dp[i + 1][j  + 1];

                dp[i][j + 1] = Math.max(take,notTake);
            }
        }

        return dp[0][0];
    }

     // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     Integer [][] dp = new Integer [n + 1][n + 1];
    //     return solve(0 , -1, nums,dp);
    // }

    // public int solve(int i , int prev , int [] nums , Integer [][] dp){
    //     int n = nums.length;
    //     if(i == n){
    //         return 0;
    //     }

    //     if(dp[i][prev + 1] != null){
    //         return dp[i][prev + 1];
    //     }
        
    //     int take = 0;
    //     if(prev == -1 || nums[i] > nums[prev]){
    //        take = 1 + solve(i + 1 , i , nums , dp);
    //     }

    //     int notTake = solve(i + 1 , prev , nums,dp);

    //     return dp[i][prev + 1] = Math.max(take,notTake); 
    // }
}