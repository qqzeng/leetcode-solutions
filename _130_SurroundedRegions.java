class Solution {
    private int m;
    private int n;
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return ;
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] == 'O') {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        
        ArrayDeque<int[]> res = new ArrayDeque<>();
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            res.offer(cell);
            int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
            for (int i = 0; i < 4; i++) {
                int nr = cell[0] + dirs[i][0];
                int nc = cell[1] + dirs[i][1];
                if (nr <= 0 || nr >= m-1 || nc <= 0 || nc >= n-1 || board[nr][nc] == 'X' || visited[nr][nc]) continue;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }
        
        while(res.size() > 0) {
            int[] cell = res.poll();
            board[cell[0]][cell[1]] = 'O';
        }
    }
}