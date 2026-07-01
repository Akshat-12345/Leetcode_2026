class Solution {
    public int lengthOfLIS(int[] nums) {

        ArrayList<Integer> tail = new ArrayList<>();

        for (int num : nums) {

            int left = 0;
            int right = tail.size();

            while (left < right) {
                int mid = (left + right) / 2;

                if (tail.get(mid) < num)
                    left = mid + 1;
                else
                    right = mid;
            }

            if (left == tail.size())
                tail.add(num);
            else
                tail.set(left, num);
        }

        return tail.size();
    }
}