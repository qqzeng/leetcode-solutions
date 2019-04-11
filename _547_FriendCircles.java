class Solution {
    private int m;
    private int n;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        m = M.length;;
        n = M[0].length;
        boolean[][] flag = new boolean[m][n];
        int count = 0;
        boolean[] visited = new boolean[m];
        for (int i = 0; i < m; i++) {
            if (visited[i]) continue;
            ArrayDeque<Integer> fq = new ArrayDeque<>();
            visited[i] = true;
            for (int j = i+1; j < n; j++) {
                if (M[i][j] == 1 && !flag[i][j]) {
                    fq.offer(j);
                    flag[i][j] = flag[j][i] = true;
                }              
            }
            count++;
            while (!fq.isEmpty()) {
                int f = fq.poll();
                visited[f] = true;
                for (int k = 0; k < n; k++) {
                    if (k != f && M[f][k] == 1 && !flag[f][k]) {
                        fq.offer(k);
                        flag[f][k] = flag[k][f] = true;
                    } 
                }
            }
        }
        
        return count;
    }
}