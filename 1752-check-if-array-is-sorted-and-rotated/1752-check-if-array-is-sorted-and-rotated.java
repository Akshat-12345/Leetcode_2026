class Solution {
    public boolean check(int[] nums) {
        int [] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int [] dup = new int [2*n];
        int j = 0;

        for(int i = 0 ; i < 2 * n ; i++){
            dup[i] = nums[i % n];
        }

        for(int i = 0 ; i < 2*n ; i++){
            if(arr[j] == dup[i] ){
                j++;
                if( j == n){
                   return true;
                }
            }else{
                j = 0;
            }
        }

        return false;
    }
}