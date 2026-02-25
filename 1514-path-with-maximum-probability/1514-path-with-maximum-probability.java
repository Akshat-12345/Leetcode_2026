class Solution {
    class pair{
        int to;
        double wt;
        public pair(int to, double wt){
            this.to = to;
            this.wt = wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i = 0 ; i< n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i= 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double w = succProb[i];

            adj.get(u).add(new pair(v, w));
            adj.get(v).add(new pair(u, w));
        }

        double [] prob = new double[n];
        Arrays.fill(prob,0.0);
        prob[start_node] = 1.0; 

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.wt, a.wt));
        pq.add(new pair(start_node,1));

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int node = curr.to;
            double currProb = curr.wt;

            for(int i = 0 ; i < adj.get(node).size() ; i++){
                pair x = adj.get(node).get(i);
                if(x.wt * currProb > prob[x.to]){
                    prob[x.to] = x.wt * currProb;
                    pq.add(new pair(x.to,prob[x.to]));
                }
            }
        }

        return prob[end_node];


    }
}