class Solution {
    int [][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int [n][n];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve( 0 , -1 , nums);
    }

    public int solve (int i , int prev , int [] arr){
        int n = arr.length;
        if( i == n){
            return 0;
        }
        
        if(dp[i][prev + 1] != -1){
            return dp[i][prev + 1];
        }

        int take = 0;
        if(prev == -1 || arr[i] > arr[prev]){
            take = 1 + solve(i + 1 , i, arr);
        }

        int notTake = solve(i + 1 , prev , arr);

        return dp[i][prev + 1] = Math.max(take,notTake);
    }

    // int [][] dp;
    // public int lengthOfLIS(int[] nums) {
    //     int n = nums.length;
    //     HashSet<Integer> set = new HashSet<>();
        
    //     for(int i = 0 ; i < n ; i++){
    //         set.add(nums[i]);
    //     }

    //     int m = set.size();
    //     int [] arr = new int [m];
    //     int k = 0;
    //     for(int x : set){
    //       arr[k] = x;
    //       k++;
    //     }
    //     Arrays.sort(arr);

    //     dp = new int [m + 1][n + 1];

    //     for(int i = 0 ; i <= m ; i++){
    //         Arrays.fill(dp[i],-1);
    //     }
    //     return solve(0,0,arr,nums);

    // }

    // public int solve(int i , int j , int [] arr, int [] nums){
    //     int n = arr.length;
    //     int m = nums.length;
    //     if(i == n || j == m ){
    //         return 0;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }
        
    //     int take = 0;
    //     if(arr[i] == nums[j]){
    //         take = 1 + solve(i +1, j + 1, arr, nums);
    //     }

    //     int notTake = Math.max(solve(i + 1, j , arr, nums), solve (i , j + 1, arr, nums));

    //     return dp[i][j] = Math.max(take,notTake);
    // }
}