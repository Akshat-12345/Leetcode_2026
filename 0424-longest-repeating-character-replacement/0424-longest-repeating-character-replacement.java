class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        
        int maxRepeatChar = 0;
        int windowStart = 0;
        int windowEnd = 0;
        int maxLen = 0;

        while(windowEnd < n){
            char ch = s.charAt(windowEnd);
            map.put(ch,map.getOrDefault(ch,0)+1);

            maxRepeatChar = Math.max(maxRepeatChar,map.get(ch));

            while(windowEnd - windowStart + 1 - maxRepeatChar > k){
                char st = s.charAt(windowStart);
                if(map.get(st) == 1){
                    map.remove(st);
                }else{
                    map.put(st,map.getOrDefault(st,0) - 1);
                }
                windowStart++;
            }

            int currLen = windowEnd - windowStart + 1;
            maxLen = Math.max(maxLen,currLen);
            windowEnd++;
        }

        return maxLen;

    }
}