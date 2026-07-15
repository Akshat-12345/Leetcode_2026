class Solution {
    public int findCircleNum(int[][] isConnected) {
         int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean [] visited = new boolean[n];
        int city = 0;
        for(int i = 0 ; i < adj.size(); i++){
              if(!visited[i]){
                  bfs(i,adj,visited);
                  city++;
              }
        }
        return city;
    }

    public void bfs (int node ,ArrayList<ArrayList<Integer>> adj, boolean [] vis ){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int n = q.remove();
            for(int i = 0; i < adj.get(n).size() ; i++){
                int curr = adj.get(n).get(i);
                if(!vis[curr]){
                    vis[curr] = true;
                    q.add(curr);
                }
            }
        }
    }
}