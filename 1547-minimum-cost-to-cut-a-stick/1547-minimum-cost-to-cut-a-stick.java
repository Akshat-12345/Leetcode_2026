import java.util.Arrays;

class Solution {

    int[][] dp;
    int[] arr;

    public int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);

        arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[arr.length - 1] = n;

        for (int i = 0; i < cuts.length; i++)
            arr[i + 1] = cuts[i];

        dp = new int[arr.length][arr.length];

        for (int[] x : dp)
            Arrays.fill(x, -1);

        return solve(0, arr.length - 1);
    }

    int solve(int i, int j) {

        if (j - i == 1)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++) {
            ans = Math.min(ans,
                    arr[j] - arr[i]
                    + solve(i, k)
                    + solve(k, j));
        }

        return dp[i][j] = ans;
    }
}