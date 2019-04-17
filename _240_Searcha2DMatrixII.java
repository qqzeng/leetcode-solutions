class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        
        if (target < matrix[0][0] || target > matrix[m-1][n-1]) return false;
        
        int r = 0;
        int c = n - 1;
        while (r < m && c >= 0) {
            if (matrix[r][c] > target) {
                c--;        
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                return true;
            }
        }
        return false;
    }
}