class Solution {
    class pair {
        int from;
        int to;
        int wt;

        public pair(int from,int to, int wt) {
            this.from = from;
            this.to = to;
            this.wt = wt;
        }

    }
    
    int [] rows = {-1,1,0,0};
    int [] cols = {0,0,-1,1};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        int [][] time = new int [n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(time[i],Integer.MAX_VALUE);
        }
        time[0][0] = grid[0][0];
        
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> (a.wt - b.wt));
        pq.add(new pair(0,0,grid[0][0]));
        
        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int currRow = curr.from;
            int currCol = curr.to;
            int currTime = curr.wt;
            
            if( currRow == n-1 && currCol == n-1){
                return currTime;
            }

            for(int i = 0; i< 4; i++){
                int row = currRow + rows[i];
                int col = currCol + cols[i];
                
                if(row >= 0 && row < n && col >= 0 && col < n ){
                    int newTime = Math.max(currTime, grid[row][col]);

                    if(newTime < time[row][col]){
                        time[row][col] = newTime;
                        pq.add(new pair(row,col,newTime));
                    }
                }
            }
            
        }
        
        return -1;
    }
}