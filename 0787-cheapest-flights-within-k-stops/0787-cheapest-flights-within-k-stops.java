// class Solution {
//     class pair{
//         int to;
//         int wt;
//         int stop;

//         public pair(int to, int wt){
//             this.to = to;
//             this.wt = wt;
//         }

//         public pair(int to, int wt ,int stop){
//             this.to = to;
//             this.wt = wt;
//             this.stop = stop;
//         }
//     }

//     public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
//         ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        
//         for(int i = 0; i < n ; i++){
//             adj.add(new ArrayList<>());
//         }
        
//         for(int i = 0; i < edges.length ; i++){
//             int u = edges[i][0];
//             int v = edges[i][1];
//             int w = edges[i][2];
//             adj.get(u).add(new pair(v,w));
//         }

//         PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
//         pq.add(new pair(src,0,k));

//         int [] price = new int[n];
//         Arrays.fill(price,Integer.MAX_VALUE);
//         price[src] = 0;
        
//         while(!pq.isEmpty()){
//             pair curr = pq.poll();
//             int node = curr.to;
//             int currFair = curr.wt;
//             int availableStop = curr.stop;
            
//             if(availableStop > 0){
//                for(int i = 0 ; i < adj.get(node).size() ; i++){
//                     pair x = adj.get(node).get(i);
//                     int nextNode = x.to;
//                     int fair = x.wt;
//                     if(price[nextNode] == Integer.MAX_VALUE || price[nextNode] > currFair + fair){
//                         price[nextNode] = currFair + fair;
//                         pq.add(new pair(nextNode,price[nextNode],availableStop-1));
//                     }
//                }
//             }
            
//         }

//         if(price[dst] == Integer.MAX_VALUE){
//             return -1;
//         }

//         return price[dst];

//     }
// }

class Solution {
    class pair {
        int to;
        int wt;
        int stop;

        public pair(int to, int wt, int stop) {
            this.to = to;
            this.wt = wt;
            this.stop = stop;
        }
    }

    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new pair(v, w, 0));
        }

        // 🔑 FIX: 2D price array
        int[][] price = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(price[i], Integer.MAX_VALUE);
        }

        PriorityQueue<pair> pq =
            new PriorityQueue<>((a, b) -> a.wt - b.wt);

        pq.add(new pair(src, 0, k + 1));
        price[src][k + 1] = 0;

        while (!pq.isEmpty()) {
            pair curr = pq.poll();
            int node = curr.to;
            int currFair = curr.wt;
            int stopsLeft = curr.stop;

            if (node == dst) return currFair;

            if (stopsLeft == 0) continue;

            for (pair x : adj.get(node)) {
                int nextNode = x.to;
                int fair = x.wt;

                if (price[nextNode][stopsLeft - 1] > currFair + fair) {
                    price[nextNode][stopsLeft - 1] = currFair + fair;
                    pq.add(new pair(
                        nextNode,
                        currFair + fair,
                        stopsLeft - 1
                    ));
                }
            }
        }

        return -1;
    }
}