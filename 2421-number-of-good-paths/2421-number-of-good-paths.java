class Solution {
    static class DSU{
        int[] parent;
        int[] rank;

        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i=0;i<n;i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);
            
            if(parentX == parentY){
                return;
            }
            
            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX;
            }
            else if(rank[parentX] <  rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            
        }
    }

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int m = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n ; i++ ){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        Map<Integer,ArrayList<Integer>> map = new TreeMap<>();
        for(int i = 0 ; i < n ; i++){
            map.putIfAbsent(vals[i],new ArrayList<>());
            map.get(vals[i]).add(i);
        }

        DSU d = new DSU(n);
        int res = 0;

        for(int key : map.keySet()){
            for(int node : map.get(key)){
                for(int neigh : adj.get(node)){
                    if(vals[neigh] <= key){
                        d.union(node,neigh);
                    }
                }
            }

            HashMap<Integer, Integer> count = new HashMap<>();

            for(int node : map.get(key)){
                int root = d.find(node);
                count.put(root, count.getOrDefault(root, 0) + 1);
            }

            for(int c : count.values()){
                res += c * (c + 1) / 2;
            }
        }

        return res;
        
    }
}