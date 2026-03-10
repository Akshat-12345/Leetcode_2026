class Solution {
    class DSU{
        int parent [];
        int rank [];
        
        public DSU(int n){
            parent = new int[n];
            rank = new int [n];

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
            
            if(parentX == parentY) return;

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

    public boolean equationsPossible(String[] equations) {
        
        int n = equations.length;
        DSU d = new DSU(26);

        for(int i = 0 ; i < n ; i++){
            String s = equations[i];

            int first = s.charAt(0) - 'a';
            int last = s.charAt(3) - 'a';

            if(s.substring(1,3).equals("==") ){
                d.union(first,last);
            }
        
        }

        for(int i = 0 ; i < n ; i++){

            String s = equations[i];

            int first = s.charAt(0) - 'a';
            int last = s.charAt(3) - 'a'; 
            
            if(s.substring(1,3).equals("!=") ){
                int x = d.find(first);
                int y = d.find(last);

                if(x == y){
                    return false;
                }
            }
        }
        return true;
    }
}