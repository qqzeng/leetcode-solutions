class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int maxProfit = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            while (i < prices.length && prices[i] >= prices[i-1]) i++;
            if (i - 1 > index) {
                maxProfit += prices[i-1] - prices[index];
            }
            index = i;
        }
        return maxProfit;
    }
    
    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n <= 1) return 0;
    //     int profit = 0;
    //     int curMin = prices[0];
    //     int curMax = prices[0];
    //     for (int i = 1; i < n; i++) {
    //         if (prices[i] > curMax) {
    //             curMax = prices[i];
    //         }
    //         else if (prices[i] < curMax) {
    //             if (curMax > curMin) {
    //                 profit += curMax - curMin;
    //                 curMin = curMax = prices[i];
    //             } else {
    //                 curMin = curMax = prices[i];
    //             }
    //         }
    //     }
    //     if (curMax > curMin) profit += curMax - curMin;
    //     return profit;
    // }
    
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int profit = 0;
        int curMin = 0, curMax = 0;
        int i = 0;
        while (i < n-1) {
            while (i < n-1 && prices[i] >= prices[i+1]) i++;
            curMin = prices[i];
            while (i < n-1 && prices[i] <= prices[i+1]) i++;
            curMax = prices[i];
            profit += curMax -curMin;
        }
        return profit;
    }
}