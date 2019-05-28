/***
	refer: https://leetcode.com/problems/ugly-number-ii/discuss/69362/O(n)-Java-solution
*/
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return -1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int f2 = 2;
        int f3 = 3;
        int f5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(f2, f3), f5);
            ugly[i] = min;
            if (min == f2) {
                f2 = 2 * ugly[++index2];
            }
            if (min  == f3) {
                f3 = 3 * ugly[++index3];
            }
            if (min == f5) {
                f5 = 5 * ugly[++index5];
            }
        }
        return ugly[n-1];
    }
}