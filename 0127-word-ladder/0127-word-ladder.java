class Solution {
    class pair{
        String word;
        int dist;
        public pair(String word,int dist){
            this.word = word;
            this.dist = dist;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        HashSet<String> st = new HashSet<>(wordList);
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(beginWord,1));
        st.remove(beginWord);

        if(!st.contains(endWord)){
            return 0;
        }

        while(!q.isEmpty()){
            pair curr = q.remove();
            String currWord = curr.word;
            int length = curr.dist;

            for(int i = 0 ; i < currWord.length(); i++){

                char[] wordArr = currWord.toCharArray();
                char temp = wordArr[i];

                for(char j = 'a'; j <= 'z' ; j++){
                    wordArr[i] = j;
                    String s = new String(wordArr);

                    if(s.equals(endWord)){
                        return length + 1;
                    }

                    if(st.contains(s)){
                        q.add(new pair(s,length + 1));
                        st.remove(s);
                    }
                }
                wordArr[i] = temp;              
            }
        }
        
        return 0;
    }
}