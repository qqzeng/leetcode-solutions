class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] nc = new int[m][n];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    nc[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    nc[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] ra = {-1, 0, 1, 0};
        int[] ca = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];
            for (int i = 0; i < ra.length; i++) {
                int newr = r+ra[i];
                int newc = c+ca[i];
                if (newr >= 0 && newr < m && newc >= 0 && newc < n){
                    if (nc[newr][newc] > nc[r][c] + 1) {
                        nc[newr][newc] = nc[r][c] + 1;
                        queue.offer(new int[]{newr, newc});
                    }
                }
            }
        }
        
        return nc;
    }
    
}