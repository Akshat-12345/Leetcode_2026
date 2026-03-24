class Solution {
    class DSU{
        int [] parent ;
        int [] rank;
        public DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if( x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);

            if(rank[parentX] > rank[parentY]){
                parent[parentY] = parentX; 
            }else if(rank[parentX] < rank[parentY]){
                parent[parentX] = parentY;
            }else{
                parent[parentY] = parentX; 
                rank[parentX]++;
            }
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU d = new DSU(n);
        boolean [] ans = new boolean[queries.length];

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // sort by value
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        // only adjacent check
        for (int i = 1; i < n; i++) {
            if (arr[i][0] - arr[i - 1][0] <= maxDiff) {
                d.union(arr[i][1], arr[i - 1][1]);
            }
        }


        for(int i = 0 ; i < queries.length ; i++){
            int u = queries[i][0];
            int v = queries[i][1];

            int pu = d.find(u);
            int pv = d.find(v);

            if(pu == pv){
               ans[i] = true;
            }else{
                ans[i] = false;
            }
        }

        return ans;
    }
}