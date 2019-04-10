/**
 refer: https://leetcode.com/problems/n-repeated-element-in-size-2n-array/discuss/208317/C%2B%2B-2-lines-O(4)-or-O-(1)
*/
class Solution {
    public int repeatedNTimes(int[] A) {
        if (A == null || A.length == 0) return -1;
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] == A[i+1] || A[i] == A[i+2]) return A[i];
        }
        return A[A.length-1];
    }
}