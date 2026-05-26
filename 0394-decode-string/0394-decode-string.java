class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i = 0 ; i < n ; i++){
           char ch = s.charAt(i);

           if(ch == ']'){
              String newS = "";

              while(!st.isEmpty() && st.peek() != '['){
                newS = st.pop() + newS;
              }

              st.pop();

              String numStr = "";
              while (!st.isEmpty() && Character.isDigit(st.peek())) {
                  numStr = st.pop() + numStr;
              }
              int val = Integer.parseInt(numStr);

              for(int j = 0 ; j < val ; j++){
                for(int k = 0 ; k < newS.length() ; k++){
                    st.push(newS.charAt(k));
                }
              }

           }else{
              st.push(ch);
           }
           
        }

        String result = "";
        while (!st.isEmpty()) {
            result = st.pop() + result;
        }
        
        return result;
    }
}