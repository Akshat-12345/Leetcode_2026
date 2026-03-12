class Solution {
    static class DSU{
        int [] parent;
        int [] size;
        int maxSize = 1;

        public DSU(int n){
            parent = new int[n];
            size = new int [n];

            for(int i = 0 ; i < n ; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int parentX = find(x);
            int parentY = find(y);

            if(parentX != parentY){
               parent[parentY] = parentX;
               size[parentX] = size[parentX] + size[parentY];

               maxSize = Math.max(maxSize,size[parentX]);
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(nums.length == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        DSU d = new DSU(n);

        for(int i = 0; i < n ; i++){
            if(map.containsKey(nums[i])) continue;
            map.put(nums[i],i);
        }

        for(int i = 0 ; i < n ; i++){
            if(map.get(nums[i]) != i) continue;
            int prevNo = nums[i] - 1;
            int suffNo = nums[i] + 1;
           
            if(map.containsKey(prevNo)){
                int j = map.get(prevNo);
                d.union(i,j);
            }

            if(map.containsKey(suffNo)){
                int j = map.get(suffNo);
                d.union(i,j);
            }
        }

        return d.maxSize;
    }
}