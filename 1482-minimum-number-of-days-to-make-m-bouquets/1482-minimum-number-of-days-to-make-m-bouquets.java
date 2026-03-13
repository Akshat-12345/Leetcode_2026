class Solution {
    public int minDays(int[] arr, int m, int k) {
        if((long)m*k > arr.length){
            return -1;
        }
        
        long MAX = 0;
        for(int i = 0 ; i < arr.length ; i++){
            MAX = Math.max(MAX,arr[i]);
        }
        
        long start = 1;
        long end = MAX;
        long ans = 0;
        
        while(start <= end){
            long mid = start + (end - start)/2;
            
            if(calculate(arr,k,m, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return (int)ans;
    }

    public boolean calculate(int[] arr, int k, int m,long mid){
        int total = m * k;
        int count = 0;
        int bouqet = 0;
        
        for(int i = 0; i < arr.length ; i++){
            if(arr[i] <= mid){
                count++;
            }else{
                count = 0;
                
            }
           
            if(count == k){
                bouqet++;
                count = 0;
            }
            
            if(bouqet >= m){
                return true;
            }
        }
        
        return false;
    }
}