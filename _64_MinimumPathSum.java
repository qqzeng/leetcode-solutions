class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // m == 1 || n == 1
        
        int[][] pathLen = new int[m][n];
        
        pathLen[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            pathLen[i][0] += pathLen[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            pathLen[0][i] += pathLen[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathLen[i][j] = Math.min(pathLen[i-1][j], pathLen[i][j-1]) + grid[i][j];
            }
        }
        
        return pathLen[m-1][n-1];
    }
}