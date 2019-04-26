class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            // Note the middle element of the array when the number is odd.
            for (int j = 0; j < (A[i].length + 1)/ 2; j++) {
                int tmp = A[i][A[i].length - j - 1] ^ 1;
                A[i][A[i].length - j - 1] = A[i][j] ^ 1;
                A[i][j] = tmp;
            }
        }
        return A;
    }
}