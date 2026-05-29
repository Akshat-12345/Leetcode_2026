class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        boolean[] visited = new boolean[26];
        
        // Count the total occurrences of each character
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            count[idx]--;
            
            // If the character is already in our result, skip it
            if (visited[idx]) {
                continue;
            }
            
            // Maintain the monotonic property
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                // Remove the last character from visited and pop it
                char removed = sb.charAt(sb.length() - 1);
                visited[removed - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            // Add current character to result
            sb.append(ch);
            visited[idx] = true;
        }
        
        return sb.toString();
    }
}