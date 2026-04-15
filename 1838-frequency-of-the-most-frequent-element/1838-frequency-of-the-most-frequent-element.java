class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        long sum = 0;
        int l = 0;
        int maxFreq = 0;

        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];

            // shrink window if cost > k
            while ((long)(r - l + 1) * nums[r] - sum > k) {
                sum -= nums[l];
                l++;
            }

            maxFreq = Math.max(maxFreq, r - l + 1);
        }

        return maxFreq;
    }
}