class Solution {
    class pair{
        int node;
        List<Integer> arr;
        public pair(int node, List<Integer> arr){
            this.node = node;
            this.arr = arr;
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Queue<pair> q = new LinkedList<>();
        List<Integer> l = new ArrayList<>();
        l.add(0);
        List<List<Integer>> ans = new ArrayList<>();
 
        q.add(new pair(0,l));
        
        while(!q.isEmpty()){
            pair curr = q.remove();
            int node = curr.node;
            List<Integer> currList = curr.arr;
            
            if(node == n - 1){
                ans.add(currList);
                continue;
            }

            for(int i : graph[node]){
                List<Integer> newList = new ArrayList<>(currList);
                newList.add(i);
                q.add(new pair(i,newList));
            }
        }

        return ans;
    }
}