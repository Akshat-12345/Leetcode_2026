class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0){
            return true;
        }
        StringBuilder newstr = new StringBuilder();
        for(int i = 0; i<s.length() ; i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                newstr.append(Character.toLowerCase(ch));
            }
            
        }

        int length = newstr.length();

         for(int i = 0; i< length/2 ; i++){
            if(newstr.charAt(i) != newstr.charAt(length - i -1)){
               return false;
            }
            
        }
        return true;

    }
}