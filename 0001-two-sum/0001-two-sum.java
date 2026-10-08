class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> mp = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int t = target - nums[i];

            if(mp.containsKey(t)){
                return new int [] {mp.get(t), i};
            }

            mp.put(nums[i],i);
        }

        return new int [] {-1,-1};
    }
}