class Solution {
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n <= 1) return 0;
    //     int min1 = 0;
    //     int minIndex1 = 0;
    //     int maxDiff1 = 0;
    //     int min2 = 0;
    //     int minIndex2 = 0;
    //     int maxDiff2 = 0;
    //     int profit = 0;
    //     for (int i = 0; i <= n; i++) {
    //         min1 = prices[0];
    //         maxDiff1 = 0;
    //         minIndex1 = 0;
    //         for (int j = 0; j < i; j++) {
    //             if (prices[j] < min1) {
    //                 min1 = prices[j];
    //                 minIndex1 = j;
    //             }
    //             if (prices[j] - min1 >= maxDiff1) {
    //                 if (j > minIndex1) {
    //                     maxDiff1 = prices[j] - min1;
    //                 }
    //             }
    //         }
    //         maxDiff2 = 0;
    //         if (i < n) {
    //             min2 = prices[i];
    //             minIndex2 = i;
    //             for (int j = i; j < n; j++) {
    //                 if (prices[j] < min2) {
    //                     min2 = prices[j];
    //                     minIndex2 = j;
    //                 }
    //                 if (prices[j] - min2 >= maxDiff2) {
    //                     if (j > minIndex2) {
    //                         maxDiff2 = prices[j] - min2;
    //                     }
    //                 }
    //             }
    //         }
    //         if (profit < maxDiff1 + maxDiff2)
    //             profit = maxDiff1 + maxDiff2;
    //     }
    //     return profit;
    // }
    
	// refer: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39611/Is-it-Best-Solution-with-O(n)-O(1).
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n <= 1) return 0;   
    //     int b1 = Integer.MIN_VALUE; // 第一次买完后手中的钱
    //     int s1 = 0; // 第一次卖完后手中的钱
    //     int b2 = Integer.MIN_VALUE; // 第二次买完后手中的钱
    //     int s2 = 0; // 第二次卖完后手中的钱
    //     for (int i = 0; i < n; i++) {
    //         b1 = Math.max(b1, -prices[i]);
    //         s1 = Math.max(s1, b1 + prices[i]);
    //         b2 = Math.max(b2, s1 - prices[i]);
    //         s2 = Math.max(s2, b2 + prices[i]);
    //     }
    //     return s2;
    // }
    
	// refer: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/39608/A-clean-DP-solution-which-generalizes-to-k-transactions
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (prices == null || n <= 1) {
            return 0;
        }
        int k = 2;
        // dp[i, j] 表示到 prices[j] 为止，能够获取的最大的利润。
        // 其中，不包括 prices[j]，并且最多交易了 k 次。
        
        // dp[i, j] = max(dp[i, j-1], prices[j] + dp[i-1, t] - prices[t]) (0<=t<=j-1)
		// 			= max(dp[i, j-1], prices[j] + max(dp[i-1, t] - prices[t]))
        int[][] dp = new int[k+1][n];
        for (int i = 1; i <= k; i++) {
            int max = dp[i-1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + max);
                max = Math.max(dp[i-1][j] - prices[j], max);
            }
        }
        return dp[k][n-1];
    }

}