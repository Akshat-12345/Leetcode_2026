class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> r = new HashMap<>();
        Map<Character,Integer> m = new HashMap<>();
        int n = ransomNote.length();
        int ma = magazine.length();
        for(int i = 0 ; i < n ; i++){
           r.put(ransomNote.charAt(i),r.getOrDefault(ransomNote.charAt(i),0)+1);
        }

        for(int i = 0 ; i < ma ; i++){
           m.put(magazine.charAt(i),m.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(char key : r.keySet()){
          if(!m.containsKey(key)){
            return false;
          }

          if(m.get(key) < r.get(key)){
            return false;
          }

        }
        return true;
    }
}