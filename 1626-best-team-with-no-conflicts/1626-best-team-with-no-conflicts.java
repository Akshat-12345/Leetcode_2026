class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int [][] arr = new int [n][2];

        for(int i = 0 ; i < n ; i++){
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int [] dp = new int [n];

        for(int i = 0 ; i < n ; i++){
            dp[i] = arr[i][1];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
                if(arr[i][1] >= arr[j][1]){
                    dp[i] = Math.max(dp[i],dp[j] + arr[i][1]);
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < n ; i++){
           max = Math.max(max,dp[i]);
        }
        return max;
    }
}