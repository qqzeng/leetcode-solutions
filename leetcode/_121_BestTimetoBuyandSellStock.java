class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0];
        int minIndex = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            
            if (prices[i] - min > maxProfit) {
                if (i > minIndex) {
                    maxProfit = prices[i] - min;
                }
            }
        }
        return maxProfit;
    }
	
	
	public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int local = 0;
        int global = 0;
		// local[i] 表示在第i天卖出所能得到的最大的利润。
		// local[i] = max (local[i-1] + prices[i] - prices[i-1], prices[i] - prices[i-1])
        for(int i=1;i < prices.length;i++){
            local = Math.max(local+prices[i]-prices[i-1],prices[i]-prices[i-1]);
            global = Math.max(local, global);
        }
        return global;
    }
}