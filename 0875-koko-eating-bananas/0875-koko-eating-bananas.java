class Solution {
    public int minEatingSpeed(int[]arr, int k) {
        int Max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            Max =Math.max(Max,arr[i]);
        }
        
        
        int start = 1;
        int end = Max;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            
            int hour = 0;
            for(int i = 0 ; i < arr.length ; i++){
                hour += Math.ceil((double)arr[i]/mid); // (arr[i] + mid - 1) / mid; 
            }
            
            if(hour > k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        
        return start;
    }
}