class Solution {
    public int getSum(int a, int b) {
        int s = a ^ b;
        int c = a & b;
        int t = 0;
        while (c != 0) {
            a = s;
            b = c << 1;
            s = a ^ b;
            c = a & b;
        }
        return s;
    }
}