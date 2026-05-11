class Solution {
    int [][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int [n + 1][amount + 1];

        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,coins,amount);
        
    }

    public int solve(int i , int [] coins, int amount){
        int n = coins.length;
        if(i == n){
            if(amount == 0){
                return 1;
            }else{
                return 0;
            }
        }
 
        if(amount == 0){
            return 1;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = 0;

        if(coins[i] <= amount ){
            take =  solve(i,coins, amount - coins[i]);
        }

        int notTake = solve(i + 1, coins , amount);

        return dp[i][amount] = take + notTake;

    }
}