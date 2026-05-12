class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        int value = 0;
        for(int i = 0; i < n ; i++ ){
            if(count == 0){
                count++;
                value = nums[i];
            }else if(nums[i] == value){
                count++;
            }else{
                count--;
            }

        }

        return value;
    }
}