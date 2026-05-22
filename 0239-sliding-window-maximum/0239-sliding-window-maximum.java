class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int m = n - k + 1;

        int [] res = new int [m];
        Deque<Integer> d = new LinkedList<>();
        int j = 0;
        for(int i = 0 ; i < n; i++){
            int val = i;

            if(!d.isEmpty() && d.peekFirst() == i - k ){
               d.pollFirst();
            }

            while(!d.isEmpty() && nums[d.peekLast()] <= nums[i]){
                d.pollLast();
            }

            d.offerLast(val);

            if(i >= k - 1){
                res[j] = nums[d.peekFirst()];
                j++;
            }
        }

        return res;


    }
}