class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;

        // Find maximum value
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // points[i] = total points earned by taking all i's
        int[] points = new int[max + 1];
        for (int num : nums) {
            points[num] += num;
        }


        for(int i = 2 ; i <= max ; i++){
            points[i] = Math.max(points[i] + points[i-2] , points[i-1]);
        }

        return points[max];
    }
}