class Solution {
    class pair{
        int from;
        int to;
        int dist;
        public pair(int to , int dist){
            this.to = to;
            this.dist = dist;
        }
    }
    public int minJumps(int[] arr) {
        int n = arr.length;
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        

        // for(int i = 0 ; i < n ; i++){
        //     adj.add(new ArrayList<>());
        // }

        // for(int i = 0 ; i < n ; i++){
        //     for(int j = i + 1 ; j < n ; j++){
        //        if(arr[i] == arr[j]){
        //           adj.get(i).add(j);
        //           adj.get(j).add(i);
        //        }
               
        //     }
        // }
        
        HashMap<Integer,List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
        }

        boolean [] vis = new boolean[n];
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0,0));
        vis[0] = true;

        while(!q.isEmpty()){
            pair curr = q.remove();
            int currNode = curr.to;
            int currDist = curr.dist;

            if(currNode == n - 1){
                return currDist;
            }

            if (adj.containsKey(arr[currNode])) {
                for (int node : adj.get(arr[currNode])) {
                    if (!vis[node]) {
                        vis[node] = true; 
                        q.add(new pair(node, currDist + 1));
                    }
                }
                adj.remove(arr[currNode]); 
            }

            if(currNode - 1 >= 0){
                if(!vis[currNode - 1]){
                    q.add(new pair(currNode - 1,currDist + 1 ));
                    vis[currNode - 1] = true;
                }
            }

            if(currNode + 1 < n){
                if(!vis[currNode + 1]){
                    q.add(new pair(currNode + 1,currDist + 1 ));
                    vis[currNode + 1] = true;
                }
            }
        }

        return -1;
    }
} 