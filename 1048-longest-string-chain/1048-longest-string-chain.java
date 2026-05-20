class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int [] dp = new int [n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 1; i < n ; i++){
            for(int j = i - 1; j >= 0 ; j--){
                if(solve(words[i], words[j])){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(dp[i],max);
            }
        }
        return max;    
    }

    public boolean solve(String a , String b){
        int n = a.length();
        int m = b.length();

        if( n != m + 1){
            return false;
        }
        
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
        // Agar characters match kar rahe hain, toh dono pointers ko aage badhao
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                // Agar match nahi kar rahe, toh sirf 'a' ke pointer ko badhao (skip 1 char)
                i++;
            }
        }
    
        // Agar 'j' string 'b' ke end tak pahunch gaya, 
        // iska matlab 'b' ke saare characters 'a' mein sahi order mein mil gaye hain.
        return j == m;

    }
}