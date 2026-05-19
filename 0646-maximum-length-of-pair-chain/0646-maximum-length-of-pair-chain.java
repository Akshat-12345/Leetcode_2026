class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,Comparator.comparingDouble(o -> o[1]));
        int n = pairs.length;
        int [] dp = new int [n];

        Arrays.fill(dp,1);
        int max = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i - 1 ; j >= 0 ; j--){
               if(pairs[i][0] > pairs[j][1]){
                  dp[i] = Math.max(dp[i], dp[j] + 1);
               }
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }
}