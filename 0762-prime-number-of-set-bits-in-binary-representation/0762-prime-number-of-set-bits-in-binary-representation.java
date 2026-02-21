class Solution {
    public int countPrimeSetBits(int left, int right) {
        boolean[] prime = new boolean[33];
        int[] p = {2,3,5,7,11,13,17,19,23,29,31};
        for (int x : p) prime[x] = true;

        int count = 0;
        for (int i = left; i <= right; i++) {
            if (prime[Integer.bitCount(i)]) count++;
        }
        return count;
    }
}