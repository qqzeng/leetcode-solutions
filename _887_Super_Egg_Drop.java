/**
	refer: https://blog.csdn.net/joylnwang/article/details/6769160
*/

class Solution {
    public int superEggDrop1(int K, int N) {
        int[][] dp = new int[K+1][N+1];
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
            dp[0][i] = 0;
        }
        
        for (int i = 2; i <= K; i++) {
            for (int j = 2; j <= N; j++) { // dp[i][j] i个鸡蛋，j层楼
                // dp[i][j] = 1 + Math.min(Math.max(dp[i-1][x-1], dp[i][k-x])) x@[1, j)
                int min = Integer.MAX_VALUE;
                for (int x = 1; x < j; x++) {
                    int max0 = Math.max(dp[i-1][x-1], dp[i][j-x]);
                    min = Math.min(max0, min);
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[K][N];
    }
    
    
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[N+1][K+1];
        int m = 0;
        while (dp[m][K] < N) {
            m++;
            for (int i = 1; i <= K; i++) {
                dp[m][i] = dp[m-1][i-1] + dp[m-1][i] + 1; 
            }
        }
        return m;
    }
}