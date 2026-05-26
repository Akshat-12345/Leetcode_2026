class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        int maxArea = 0;
        int i = 0;
        int j = n - 1;

        while(i < j){
            int currArea = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea,currArea);
            if(height[i] >= height[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxArea;
    }
}