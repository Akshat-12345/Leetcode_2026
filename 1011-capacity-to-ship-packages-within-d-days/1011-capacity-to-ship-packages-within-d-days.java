class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxWeight = 0;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
           sum += weights[i];
           maxWeight = Math.max(maxWeight, weights[i]);
        }

        int s = maxWeight;
        int e = sum;
        int res = 0;
        while(s <= e){
            int mid = s + (e - s)/2;
            
            if(isPossible(weights,days,mid)){
                res = mid;
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }

        return res;
    }

    public boolean isPossible(int [] weights , int days , int mid){
        int n = weights.length;
        int countWeight = 0;

        int totalDays = 1;

        for(int i = 0; i < n ; i++){
            if (weights[i] > mid) {
               return false;
            }
            if(countWeight + weights[i] > mid){
                totalDays++;
                countWeight = weights[i];
            }else{
                countWeight += weights[i];
            }
        }

        if(totalDays > days){
            return false;
        }
        return true;
    }
}