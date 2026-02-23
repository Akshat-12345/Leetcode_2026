class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> ans = new ArrayList<>();

        if (!dict.contains(endWord)) return ans;

        // word -> list of parents
        Map<String, List<String>> parentMap = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();

            for (int k = 0; k < size; k++) {
                String curr = q.poll();
                char[] arr = curr.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;
                        String next = new String(arr);

                        if (!dict.contains(next)) continue;

                        if (!visited.contains(next)) {
                            if (!parentMap.containsKey(next)) {
                                parentMap.put(next, new ArrayList<>());
                            }
                            parentMap.get(next).add(curr);

                            if (next.equals(endWord)) {
                                found = true;
                            }

                            if (levelVisited.add(next)) {
                                q.add(next);
                            }
                        }
                    }
                    arr[i] = original;
                }
            }
            visited.addAll(levelVisited);
        }

        if (!found) return ans;

        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, parentMap, path, ans);

        return ans;
    }

    private void backtrack(String word, String beginWord,
                           Map<String, List<String>> parentMap,
                           List<String> path,
                           List<List<String>> ans) {

        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if (!parentMap.containsKey(word)) return;

        for (String parent : parentMap.get(word)) {
            path.add(parent);
            backtrack(parent, beginWord, parentMap, path, ans);
            path.remove(path.size() - 1);
        }
    }
}