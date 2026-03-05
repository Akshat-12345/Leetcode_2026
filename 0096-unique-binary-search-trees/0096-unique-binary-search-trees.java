class Solution {
    public int numTrees(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }

    public int solve(int n , int [] dp){
        if(n == 0 || n == 1 ){
            return 1;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        int ans = 0;
        for(int i = 0; i < n ; i++){
            int lefttree = solve(i,dp);
            int righttree = solve(n-i-1,dp);
            ans += lefttree * righttree;
        }
        
        return dp[n] = ans;
    }
}