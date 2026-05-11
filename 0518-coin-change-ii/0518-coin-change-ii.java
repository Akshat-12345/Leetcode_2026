class Solution {
    int [][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int [n + 1][amount + 1];
        
        for(int i = 0 ; i <=n ; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n ; i++){
            int val = coins[i-1];
            for(int j = 1; j <= amount ; j++){
               if(j >= val){
                 dp[i][j] = dp[i][j-val] + dp[i-1][j];
                }else{
                  dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amount];
        
        // for(int i = 0 ; i <= n ; i++){
        //     Arrays.fill(dp[i],-1);
        // }

        // return solve(0,coins,amount);
        
    }

    // public int solve(int i , int [] coins, int amount){
    //     int n = coins.length;
    //     if(i == n){
    //         if(amount == 0){
    //             return 1;
    //         }else{
    //             return 0;
    //         }
    //     }
 
    //     if(amount == 0){
    //         return 1;
    //     }

    //     if(dp[i][amount] != -1){
    //         return dp[i][amount];
    //     }

    //     int take = 0;

    //     if(coins[i] <= amount ){
    //         take =  solve(i,coins, amount - coins[i]);
    //     }

    //     int notTake = solve(i + 1, coins , amount);
    //     return dp[i][amount] = take + notTake;

    // }
}