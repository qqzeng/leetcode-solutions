class Solution {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    countIands(visited, grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void countIands(boolean[][] visited, char[][] grid, int r, int c) {
        visited[r][c] = true;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nr = r + dirs[i][0];
            int nc = c + dirs[i][1];
            if (nr < 0 || nr >= m || nc < 0 || nc >= n || visited[nr][nc] || grid[r][c] == '0') continue;
            countIands(visited, grid, nr, nc);
        }
    }
}