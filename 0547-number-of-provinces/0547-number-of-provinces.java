class Solution {
    static class Dsu{
        int parent [];
        public Dsu(int n){
            parent = new int[n];
            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find (int x ){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x , int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX != parentY){
               parent[parentY] = parentX;
            }         
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Dsu d = new Dsu(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < isConnected[0].length ; j++){
                if(isConnected[i][j] == 1){
                    d.union(i,j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n ; i++){
            int x = d.find(i);
            set.add(x);
        }

        return set.size();

        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // for (int i = 0; i < n; i++) {
        //     adj.add(new ArrayList<>());
        // }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         if (isConnected[i][j] == 1) {
        //             adj.get(i).add(j);
        //         }
        //     }
        // }

        // boolean [] visited = new boolean[n];
        // int city = 0;
        // for(int i = 0 ; i < adj.size(); i++){
        //       if(!visited[i]){
        //           dfs(i,adj,visited);   // jitne components honge utne hee aone province honge 
        //           city++;
        //       }
        // }
        // return city;
    }

    // public void bfs (int node ,ArrayList<ArrayList<Integer>> adj, boolean [] vis ){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(node);
    //     vis[node] = true;
    //     while(!q.isEmpty()){
    //         int n = q.remove();
    //         for(int i = 0; i < adj.get(n).size() ; i++){
    //             int curr = adj.get(n).get(i);
    //             if(!vis[curr]){
    //                 vis[curr] = true;
    //                 q.add(curr);
    //             }
    //         }
    //     }
    // }

    // public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
    
    //     vis[node] = true;
    
    //     for (int i = 0; i < adj.get(node).size(); i++) {
    //         int curr = adj.get(node).get(i);
    //         if (!vis[curr]) {
    //             dfs(curr, adj, vis);
    //         }
    //     }
    // }

}