class Solution {
    public int maxDistance(int[]stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int ans = 0;
        int start = 1;
        int end = stalls[n-1] - stalls[0];
        
        while(start <= end){
            int mid = (start + end)/2;
            
            if(possible(mid,stalls,k)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }

    public boolean possible(int mid , int [] stalls, int k){
        int n = stalls.length;
        int count = 1;
        int lastPos = stalls[0];
        
        for(int i = 0 ; i < n ; i++){
            if(stalls[i] - lastPos >= mid){
                count++;
                lastPos = stalls[i];
            }
        }
        
        if(count >= k){
            return true;
        }
        
        return false;
    }
}