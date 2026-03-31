class Solution {
    Boolean [][] dp;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        int total = stones[n-1];
        dp = new Boolean[n + 1][n + 1];
        return solve(0,0,stones); // i, k , total
    }
    
    public int search(int target , int [] stones){
        int s = 0;
        int e = stones.length - 1;

        while(s <= e){
            int mid = s + (e - s)/2;

            if(target == stones[mid]){
                return mid;
            }else if(target > stones[mid]){
                s = mid + 1;
            }else{
                e = mid - 1;
            }

        }
        return -1;
    }

    public boolean solve(int i , int k , int [] stones){
        int n = stones.length;

        if(i == n - 1){
            return true;
        }

        if(dp[i][k] != null ){
            return dp[i][k];
        }
        
        for(int j = k - 1 ; j <= k + 1 ; j++){
            if(j <= 0){
                continue;
            }
            int currTotal = stones[i] + j;
            int idx = search(currTotal,stones);

            if(idx != -1){
                if(solve(idx , j , stones)){
                    return dp[i][k] = true;
                }
            }
        }
        return dp[i][k] = false;
    }
}