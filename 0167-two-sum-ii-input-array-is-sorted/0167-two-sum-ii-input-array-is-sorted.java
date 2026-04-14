class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i = 0 ; i < n ; i++){
            int diff = target - numbers[i];
            int calcIdx = binarySearch(numbers,diff, i + 1);
            if( calcIdx != -1){
                return new int[] {i + 1 , calcIdx + 1};
            }
        }

        return new int[] {-1,-1};
    }

    public int binarySearch(int [] nums , int target, int s){
        int e = nums.length - 1;

        while(s <= e){
            int mid = (s  + e)/ 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                e = mid - 1;
            }else{
                s = mid + 1;
            }
        }
        return -1;
    }
}