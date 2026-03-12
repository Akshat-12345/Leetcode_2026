class Solution {
    class pair{
    int u;
    int v;

        pair(int u,int v){
            this.u = u;
            this.v = v;
        }
    }

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

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        int m = meetings.length;
        DSU d = new DSU(n);
        
        Arrays.sort(meetings,Comparator.comparingInt( o -> o[2]));
        d.union(0,firstPerson);
        
        Map<Integer , List<pair>> map = new HashMap<>();
        for(int[] meet : meetings){
        
            int u = meet[0];
            int v = meet[1];
            int t = meet[2];       
            map.computeIfAbsent(t , k -> new ArrayList<>()).add(new pair(u,v));
        }
        
        List<Integer> times = new ArrayList<>(map.keySet());
        Collections.sort(times);
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        set.add(firstPerson);

        // for(int i = 0; i < times.size() ; i++){
        //     int time = times.get(i);
        //     List<pair> listPair = map.get(time);
            
        //     for(int j = 0 ; j < listPair.size(); j++){
        //         pair x = listPair.get(j);
        //         int parentU = d.find(x.u);
        //         int parentV = d.find(x.v);
                
        //         if(parentU == d.find(0)){
        //             d.union(x.u,x.v);
        //             set.add(x.v);
        //         }else if(parentV == d.find(0)){
        //             d.union(x.u,x.v);
        //             set.add(x.u);
        //         }
        //     }
        // }

        for(int time : times){
    
            List<pair> listPair = map.get(time);
            HashSet<Integer> persons = new HashSet<>();
        
            for(pair p : listPair){
                d.union(p.u , p.v);
                persons.add(p.u);
                persons.add(p.v);
            }
        
            for(int person : persons){
                if(d.find(person) != d.find(0)){
                    d.parent[person] = person;
                }else{
                    set.add(person);
                }
            }
        }

        List<Integer> ans = new ArrayList<>(set);
        return ans;

    }
}