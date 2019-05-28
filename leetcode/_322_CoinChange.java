class Solution {
    
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
		        return 0;
        int[] memo = new int[amount + 1];
        for (int i = 1; i <= amount; i++)  memo[i] = Integer.MAX_VALUE;
        memo[0] = 0;
        return DFSConinChange(coins, amount, memo);
    }
    
    private int DFSConinChange(int[] coins, int remain, int[] memo) {
        if (remain < 0) return -1;
        if (memo[remain] != Integer.MAX_VALUE) return memo[remain];
        for (int i = 0; i < coins.length; i++) {
            int tmp = DFSConinChange(coins, remain - coins[i], memo);
            if (tmp >= 0) memo[remain] = Math.min(memo[remain], tmp + 1);
        }
        memo[remain] = memo[remain] == Integer.MAX_VALUE ? -1 : memo[remain];
        return memo[remain];
    }
    
    
    public int coinChange1(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0)
		        return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=0 && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
    }
}