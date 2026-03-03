class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n + 1][amount+1];
        int INF = 10000000;
        for(int j = 0 ; j <= amount ; j++){
            dp[0][j] = INF;
        }

        for(int i = 0 ; i <= n ; i++){
            dp[i][0] = 0;
        }

        for(int i = 1 ; i < n + 1 ; i++){
            for(int j = 1 ; j < amount + 1 ; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i-1][j],1 + dp[i][j-coins[i-1]]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        if(dp[n][amount] == INF){
            return -1;
        }
        return dp[n][amount];
        // for(int i = 0 ; i < dp.length; i ++){
        //     Arrays.fill(dp[i],-1);
        // }
        // int ans = solve(coins,amount,0,dp);
        // return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    // public int solve(int[] arr, int amount, int i ,int [][] dp){
    //     if(amount == 0){
    //         return 0;
    //     }

    //     if(amount > 0 && i == arr.length){
    //         return Integer.MAX_VALUE;
    //     }
        
    //     if(dp[i][amount] != -1){
    //         return dp[i][amount];
    //     }
        
    //     int pick = Integer.MAX_VALUE;
    //     if(arr[i] <= amount){
    //         int res =  solve(arr, amount - arr[i], i, dp);
    //         if (res != Integer.MAX_VALUE) {
    //             pick = 1 + res;
    //         }
    //     }

    //     int notpick = solve(arr, amount, i+1, dp);

    //     return dp[i][amount] = Math.min(pick,notpick);
    // }

}