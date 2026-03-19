class NumMatrix {
    int [][] prefix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m  =matrix[0].length;

        prefix = new int [n][m];
        prefix[0][0] = matrix[0][0];

        for(int i = 1 ; i < n ; i++){
           prefix[i][0] = prefix[i-1][0] + matrix[i][0];
        }

        for(int j = 1 ; j < m; j++){
           prefix[0][j] = prefix[0][j-1] + matrix[0][j];
        }

        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < m ; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + matrix[i][j] - prefix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int r1, int c1, int r2, int c2) {
       int total = prefix[r2][c2];

       int up = (r1 > 0) ? prefix[r1-1][c2] : 0;
       int left = (c1 > 0) ? prefix[r2][c1-1] : 0;
       int diag = (r1 > 0 && c1 > 0) ? prefix[r1-1][c1-1] : 0;
   
       return total - up - left + diag;

    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */