class Solution {
    class pair{
        int from;
        int to;int wt;
        public pair(int from, int to, int wt){
            this.from = from;
            this.to = to;
            this.wt = wt;
        }
    }

    int maxDist = 0;

    int [] rows = {-1,1,0,0};
    int [] cols= {0,0,-1,1};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int [][] effort = new int[n][m];
        for(int i = 0 ; i< n ; i++){
            Arrays.fill(effort[i],Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new pair(0,0,0));


        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int currRow = curr.from;
            int currCol = curr.to;
            int currDist = curr.wt;

            for(int i = 0 ; i < 4 ; i++){
                int row = currRow + rows[i];
                int col = currCol + cols[i];

                if(row >= 0 && row < n && col >= 0 && col < m ){

                    int eff = Math.max(currDist,Math.abs(heights[currRow][currCol] - heights[row][col]));
                    if(eff < effort[row][col]){
                        effort[row][col] = eff;
                        pq.add(new pair(row,col,eff));
                    }            
                }
            }
        }

        return effort[n-1][m-1];

    }
}