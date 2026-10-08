class Solution {
    public boolean isAnagram(String s, String t) {
        String s1 = s.toLowerCase();
        String t1 = t.toLowerCase();

        char [] arr = s1.toCharArray();
        char [] res  = t1.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(res);
        
        if(s1.length() == t1.length()){
            if(Arrays.equals(arr,res)){
                return true;
            }
        }

        return false;   
    }
} 