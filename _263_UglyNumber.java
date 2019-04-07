class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        int[] factors = new int[]{2,3,5};
        boolean more = false;
        while (num > 1) {
            more = false;
            for (int i = 0; i < factors.length; i++) {
                if (num % factors[i] == 0) {
                    num /= factors[i];
                    more = true;
                }
            }
            if (!more) break;
        }
        return num == 1;
    }
}