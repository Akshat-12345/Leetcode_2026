class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();

        if(s1.length() == t1.length()){
            char[] arrays = s1.toCharArray();
            char[] arrayt = t1.toCharArray();

            Arrays.sort(arrays);
            Arrays.sort(arrayt);

            if(Arrays.equals(arrays,arrayt)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}