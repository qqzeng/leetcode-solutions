public class Solution {
    public int Fibonacci1(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
    
    public int Fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int prev1 = 1;
        int prev2 = 0;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}