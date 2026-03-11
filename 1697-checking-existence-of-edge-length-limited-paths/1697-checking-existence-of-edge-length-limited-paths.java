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

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int t = edgeList.length;
        int m = queries.length;
        DSU d = new DSU(n);
        boolean [] ans = new boolean [m];
        
        int [][] newQuery = new int[m][4];
        
        for(int i = 0; i < m ; i++){
            newQuery[i][0] = queries[i][0];
            newQuery[i][1] = queries[i][1];
            newQuery[i][2] = queries[i][2];
            newQuery[i][3] = i;
        }
        
        Arrays.sort(edgeList,Comparator.comparingInt(o -> o[2]));
        Arrays.sort(newQuery,Comparator.comparingInt(o -> o[2]));
        
        int j = 0;
        for(int i = 0 ; i < m ; i++){
            int src = newQuery[i][0];
            int dst = newQuery[i][1];
            int limit = newQuery[i][2];
            int idx = newQuery[i][3];

            // for(int j = 0 ; j < t ; j++){
            //     int u = edgeList[j][0];
            //     int v = edgeList[j][1];
            //     int dist = edgeList[j][2];

            //     if(dist < limit){
            //         d.union(u,v);
            //     }
            // }

            while( j < t && edgeList[j][2] < limit){              
                d.union(edgeList[j][0], edgeList[j][1]);             
                j++;               
            }

            if(d.find(src) == d.find(dst)){
                    ans[idx] = true;
            }
        }

        return ans;
    }
}