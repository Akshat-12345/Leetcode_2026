class Solution {
    public class pair{
        int from;
        int to;
        int cost;
        public pair(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public boolean isValidate(int row, int col , int n , int m){
        if(row >= 0 && row < n && col >= 0 && col < m){
            return true;
        }
        return false;
    }

    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.add(new pair(0,0,0));

        int[][] dist = new int[n][m];
        for (int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);
        dist[0][0] = 0;

        int[] rows = {0, 0, 1, -1};   
        int[] cols = {1, -1, 0, 0};

        while(!pq.isEmpty()){
            pair curr = pq.poll();
            int currRow = curr.from;
            int currCol = curr.to;
            int currCost = curr.cost;
            int currDirection = grid[currRow][currCol];
            
            if (currCost > dist[currRow][currCol]) continue;

            if(currRow == n-1 && currCol == m-1){
                return currCost;
            }

            for(int i = 0 ; i < 4 ; i++){
                int row = currRow + rows[i];
                int col = currCol + cols[i];

                if(isValidate(row,col,n,m)){
                    int newCost = 0;
                    if(currDirection != i + 1  ){
                        newCost = currCost + 1;
                    }else{
                        newCost = currCost;
                    }

                    if(dist[row][col] > newCost){
                        pq.add(new pair(row,col,newCost));
                        dist[row][col] = newCost;
                    }
                }
            }
        }

        return 0;
    }
}