class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int [][] dp = new int [n + 1][m + 1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[1][1] = triangle.get(0).get(0);

        for(int i = 2 ; i < dp.length ;  i ++){
           for(int j = 1 ; j <= i ; j++){
            int minVal = Math.min(dp[i-1][j-1],dp[i-1][j]);

            if(minVal != Integer.MAX_VALUE){
                dp[i][j] = minVal  + triangle.get(i-1).get(j-1);
            }
            //   if(dp[i-1][j] != Integer.MAX_VALUE || dp[i-1][j-1] != Integer.MAX_VALUE){
            //      dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j-1]) + triangle.get(i-1).get(j-1);
            //   }             
           }
        }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < dp[0].length ; i++){
            ans = Math.min(ans,dp[n][i]);
        }

        return ans;
    }
}