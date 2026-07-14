class Solution {
    public int splitArray(int[] nums, int k) {
        int s = 0;
        int e = 0;
        int n = nums.length;

        for(int i =0 ; i < n ; i++){
            s = Math.max(s,nums[i]);
            e += nums[i];
        }
        
        int ans = 0;
        while(s <= e){
            int m = s + (e - s)/2;

            if(isPossible(nums , k , m)){
                ans = m;
                e = m - 1;
            }else{
                s = m + 1;
            }
        }
        
        return ans;
    }

    public boolean isPossible(int [] nums , int k , int m){
        int total = 0;
        int count = 1;
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            if(total + nums[i] > m){
               count++;
               total = 0;
            }
            total += nums[i];
        }

        if(count > k){
            return false;
        }
        return true;
    }
}