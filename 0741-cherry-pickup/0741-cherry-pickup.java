class Solution {
    Integer [][][] dp ;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        dp = new Integer [n][n][n];
        return Math.max(0,solve(0,0,0,grid));
    }

    public int solve(int r1, int c1 , int r2, int [][] grid){
        int c2 = r1 + c1 - r2;
        int n = grid.length;

        if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }

        if(r1 == n-1 && c1 == n -1){
            return grid[r1][c1];
        }

        if(dp[r1][c1][r2] != null){
           return dp[r1][c1][r2];
        }

        int totalChery = 0;

        if(r1 == r2 && c1 == c2){
            totalChery += grid[r1][c1];
        }else{
            totalChery += grid[r1][c1] + grid[r2][c2];
        }

        int downRight = solve(r1 + 1 , c1 , r2 , grid);
        int downDown = solve(r1 + 1 , c1 , r2 + 1, grid);
        int rightDown = solve(r1 , c1 + 1, r2 + 1, grid);
        int rightRight = solve(r1 , c1 + 1 , r2 , grid);

        int max = Math.max(Math.max(downRight,downDown), Math.max(rightDown,rightRight));

        if(max == Integer.MIN_VALUE){
           return dp[r1][c1][r2] = Integer.MIN_VALUE;
        }

        return dp[r1][c1][r2] = totalChery + max;
    }
} 