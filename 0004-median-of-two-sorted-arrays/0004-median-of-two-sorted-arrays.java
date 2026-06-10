class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n1 = nums1.length;
        int n2 = nums2.length;

        int total = n1 + n2;
        int i = 0, j = 0;

        int prev = 0, curr = 0;

        // Median position tak hi traverse karna hai
        for (int count = 0; count <= total / 2; count++) {

            prev = curr;

            if (i < n1 && (j >= n2 || nums1[i] <= nums2[j])) {
                curr = nums1[i];
                i++;
            } else {
                curr = nums2[j];
                j++;
            }
        }

        // Odd length
        if (total % 2 == 1) {
            return curr;
        }

        // Even length
        return (prev + curr) / 2.0;
    }
}