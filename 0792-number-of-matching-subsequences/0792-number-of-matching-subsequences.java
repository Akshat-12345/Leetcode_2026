class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, ArrayList<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)){
               map.put(ch, new ArrayList<>());
            }
            map.get(ch).add(i);
        }
        
        int count = 0;

        for(int i = 0; i < words.length ; i++ ){
            int previdx = -1;
            boolean found = true;
            String word = words[i];
            for(int j = 0 ; j < word.length() ; j++){
                char ch = word.charAt(j);
                if(!map.containsKey(ch)){
                   found = false;
                   break;
                }
                ArrayList<Integer> curr = map.get(ch);
                int idx = Collections.binarySearch(curr,previdx + 1);
                
                if(idx < 0)
                    idx = -idx - 1;

                if(idx == curr.size()){
                    found = false;
                    break;
                }

                previdx = curr.get(idx);
            }
            
            if(found){
                count++;
            }
        }
        return count;
    }

   
}