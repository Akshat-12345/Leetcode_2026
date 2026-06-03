class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        int [][] dp = new int [n][m];

        for(int i = 0; i < n ; i++ ){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }

        return solve(0,0,triangle,dp);
    }

    public int solve(int i , int j , List<List<Integer>> triangle, int [][] dp ){
        int n = triangle.size();

        if(i == n -1){
            return triangle.get(i).get(j);
        }

        if(dp[i][j] != Integer.MAX_VALUE){
            return dp[i][j];
        }

        int left = solve(i+1,j,triangle,dp);
        int right = solve(i+1,j+1,triangle,dp);

        return dp[i][j] = Math.min(left,right) + triangle.get(i).get(j);
    }
}