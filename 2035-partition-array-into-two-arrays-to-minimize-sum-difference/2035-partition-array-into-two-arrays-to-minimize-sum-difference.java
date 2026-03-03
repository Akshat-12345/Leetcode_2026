import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        
        int total = 0;
        for (int x : nums) total += x;

        // split into two halves
        int[] left = Arrays.copyOfRange(nums, 0, half);
        int[] right = Arrays.copyOfRange(nums, half, n);

        // list of sums grouped by number of elements picked
        List<Integer>[] leftSums = new ArrayList[half + 1];
        List<Integer>[] rightSums = new ArrayList[half + 1];

        for (int i = 0; i <= half; i++) {
            leftSums[i] = new ArrayList<>();
            rightSums[i] = new ArrayList<>();
        }

        // generate subset sums for left
        for (int mask = 0; mask < (1 << half); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += left[i];
                    count++;
                }
            }
            leftSums[count].add(sum);
        }

        // generate subset sums for right
        for (int mask = 0; mask < (1 << half); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += right[i];
                    count++;
                }
            }
            rightSums[count].add(sum);
        }

        // sort right side for binary search
        for (int i = 0; i <= half; i++) {
            Collections.sort(rightSums[i]);
        }

        int answer = Integer.MAX_VALUE;

        // try all possible splits
        for (int k = 0; k <= half; k++) {

            List<Integer> leftList = leftSums[k];
            List<Integer> rightList = rightSums[half - k];

            for (int leftSum : leftList) {

                // target right sum we want close to
                int target = total / 2 - leftSum;

                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0) idx = -idx - 1;

                // check idx
                if (idx < rightList.size()) {
                    int sum = leftSum + rightList.get(idx);
                    answer = Math.min(answer, Math.abs(total - 2 * sum));
                }

                // check idx - 1
                if (idx > 0) {
                    int sum = leftSum + rightList.get(idx - 1);
                    answer = Math.min(answer, Math.abs(total - 2 * sum));
                }
            }
        }

        return answer;
    }
}