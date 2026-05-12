class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        solve(0,n-1,nums);
        solve(0,k - 1 ,nums);
        solve(k, n- 1,nums);
    }

    public void solve(int s , int e , int [] nums){
        while(s < e){
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;

            s++;
            e--;
        }
    }
}