public class Solution {
    public int JumpFloor(int target) {
        if (target == 0) return 1;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int[] dp = new int[target+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
    
    public int JumpFloor1(int target) {
        if (target == 0) return 1;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int prev2 = 1;
        int prev1 = 2;
        int current = 0;
        for (int i = 3; i <= target; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}