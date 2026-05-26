class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        int close = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '('){
                open++;
            }else if (s.charAt(i) == ')' && open > 0){
                open--;
            }else{
                close++;
            }
        }

        return open + close;
    }
}