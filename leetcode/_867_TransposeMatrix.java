class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] tranposeArr = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tranposeArr[j][i] = A[i][j];
            }
        }
        return tranposeArr;
    }
}