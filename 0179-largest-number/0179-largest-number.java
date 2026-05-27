import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }
        
        // 2. Custom sort based on combinations (b + a) vs (a + b)
        // Descending order mein sort karne ke liye (b + a).compareTo(a + b) use kiya hai
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
        

        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String str : strNums) {
            sb.append(str);
        }
        
        return sb.toString();
    }
}