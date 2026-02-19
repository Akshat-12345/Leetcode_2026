class Solution {
    public boolean canFinish(int numCourses, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        int indegree[] = new int[numCourses];
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        
        ArrayList<Integer> result = new ArrayList<>();
        

        
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                que.add(i);
            }
            
        }
        
        while ( !que.isEmpty()) {
            int curr = que.poll();
            result.add(curr);
            
            for (int x : adj.get(curr)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    que.add(x);
                }
            }
            
        }
        
        if(result.size() == numCourses){
            return true;
        }

        return false;
    }
}