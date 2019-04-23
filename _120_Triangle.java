class Solution {

	public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int m = triangle.size();
        int n = triangle.get(0).size();
        
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) dp[i] = triangle.get(m-1).get(i);
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null) return 0;
        int m = triangle.size();
        int n = triangle.get(0).size();
        
        int[][] dp = new int[m][m];
        for (int i = 0; i < m; i++) dp[m-1][i] = triangle.get(m-1).get(i);
        
        for (int i = m-2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0][0];
    }

    // public int minimumTotal(List<List<Integer>> triangle) {
    //     if (triangle.size() == 1) return triangle.get(0).get(0);
    //     int m = triangle.size();
    //     int n = triangle.get(triangle.size()-1).size();
    //     int[][] minLen = new int[m][n];
    //     for (int i = 0; i < n; i++) {
    //         minLen[m-1][i] = triangle.get(m-1).get(i);
    //     }
    //     for (int i = m-2; i >= 0 ; i--) {
    //         List<Integer> row = triangle.get(i);
    //         for (int j = 0; j <= i; j++) {
    //             minLen[i][j] = Math.min(minLen[i+1][j], minLen[i+1][j+1]) + row.get(j);
    //         }
    //     }
    //     return minLen[0][0];
    // }
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int m = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[] minLen = new int[n];
        
        List<Integer> lastRow = triangle.get(m-1);
        for (int i = 0; i < n; i++) {
            minLen[i] = lastRow.get(i);
        }
        
        for (int i = m-2; i >= 0; i--) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                minLen[j] = Math.min(minLen[j], minLen[j+1]) + row.get(j);
            }
        }
        return minLen[0];
    }

}