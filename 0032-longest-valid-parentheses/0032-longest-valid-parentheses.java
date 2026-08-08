class Solution {
    public int longestValidParentheses(String str) {
        int maxLen = 0;
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i = 0 ; i < str.length() ; i++){
            char c = str.charAt(i);
            if(c == '('){
                s.push(i);
            }else{
                s.pop();
                if (s.isEmpty()) {
                    s.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - s.peek());
                }
            }
        }
        return maxLen;
    }
}