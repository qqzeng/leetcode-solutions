public class Solution {
    public int Sum_Solution(int n) {
        int ans = n;
        boolean t=((ans!=0) && ((ans += Sum_Solution(n - 1))!=0));
        return ans;
    }
}