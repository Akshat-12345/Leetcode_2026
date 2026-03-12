class Solution {
    static class DSU{
        int[] parent;
        int[] rank;
        int components;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            components = n;

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
            components--;
        }
    }

    public boolean check(String a , String b){
        int n = a.length();
        int m = b.length();

        if(n != m){
            return false;
        }
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }

            if(count > 2){
               return false;
            }
        }
        
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU d = new DSU(n);

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(check(strs[i],strs[j])){
                    d.union(i,j);
                }
            }
        }

        return d.components;
    }

    
}