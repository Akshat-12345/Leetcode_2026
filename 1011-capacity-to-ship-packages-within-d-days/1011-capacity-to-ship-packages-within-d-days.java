class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int i = 0 ; i < weights.length ; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }

        int start = max;
        int end = sum;
        int ans = 0;

        while(start  <= end){
            int mid = start + (end - start)/2;
            if(solve(weights,days,mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public boolean solve(int [] weights, int days , int mid){
        int count = 0;
        int totalDays = 1;
        for(int i = 0 ; i < weights.length ; i++){
            if(count + weights[i] > mid){
               totalDays++;
               count = weights[i];
            }
            else{
               count += weights[i];
            }
        }

        if(totalDays <= days){
            return true;
        }

        return false;
    }
}