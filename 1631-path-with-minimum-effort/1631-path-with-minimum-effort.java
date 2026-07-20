class Solution {
    class pair{
        int from;
        int to;
        int wt;
        public pair(int from , int to , int wt){
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int [][] dist = new int [n][m];

        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        
        pq.add(new pair(0,0,0));

        while(!pq.isEmpty()){
            pair curr = pq.poll();

            for(int i = 0 ; i < 4 ; i++){
                int cr = curr.from + rows[i];
                int cc = curr.to + cols[i];

                if(cr >= 0 && cr < n && cc >= 0 && cc < m ){
                    int val = Math.max(curr.wt,Math.abs(heights[cr][cc] - heights[curr.from][curr.to]));
                    if( val < dist[cr][cc]){
                        pq.add(new pair(cr,cc,val));
                        dist[cr][cc] = val;
                    }
                }
            }
        }

        return dist[n-1][m-1];
    }
}