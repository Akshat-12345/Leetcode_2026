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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> map = new HashMap<>();
        int n = accounts.size();

        DSU dsu = new DSU(n);
        
        for(int i = 0 ; i < n ; i ++){
            for(int j = 1; j < accounts.get(i).size(); j++){

                String email = accounts.get(i).get(j);

                if(map.containsKey(email)){
                    dsu.union(i , map.get(email));
                }else{
                    map.put(email , i);
                }              
            }
        }

        Map<Integer , List<String>> merged = new HashMap<>();

        for(String email : map.keySet()){
            int parent = dsu.find(map.get(email));      
            merged.putIfAbsent(parent , new ArrayList<>());
            merged.get(parent).add(email);
        }


        List<List<String>> ans = new ArrayList<>();

        for(int parent : merged.keySet()){
        
            List<String> emails = merged.get(parent);
            Collections.sort(emails);
        
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(parent).get(0)); // name
            temp.addAll(emails);
        
            ans.add(temp);
        }
        
        return ans;
    }
}