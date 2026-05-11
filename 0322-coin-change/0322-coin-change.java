class Solution {
    int [][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int [n + 1][amount + 1];

        for(int i = 0 ; i <= n ; i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = solve(0,coins,amount);
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }

    public int solve(int i , int [] coins, int amount){
        int n = coins.length;
        if(i == n){
            if(amount == 0){
                return 0;
            }else{
                return Integer.MAX_VALUE;
            }
        }
 
        if(amount == 0){
            return 0;
        }

        if(dp[i][amount] != -1){
            return dp[i][amount];
        }

        int take = Integer.MAX_VALUE;

        if(coins[i] <= amount && solve(i,coins, amount - coins[i]) != Integer.MAX_VALUE){

            take = 1 + solve(i,coins, amount - coins[i]);
        }

        int notTake = solve(i + 1, coins , amount);

        return dp[i][amount] = Math.min(take,notTake);

    }
}