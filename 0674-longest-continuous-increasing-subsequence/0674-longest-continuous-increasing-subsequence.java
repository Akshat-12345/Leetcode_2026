class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int maxlen = 1;
        int count = 1;

        for(int i = 0; i < nums.length - 1 ; i++){
            if(nums[i + 1] > nums[i]){
                count++;
            }else{
                count =1;
            }
            maxlen = Math.max(maxlen, count);
        }
        return maxlen;
    }
}