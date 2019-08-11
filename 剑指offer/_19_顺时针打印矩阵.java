import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
       ArrayList<Integer> res = new ArrayList<Integer>();
       if (matrix == null) return res;
       int rows = matrix.length;
       int cols = matrix[0].length;
       if (rows <= 0 || cols <= 0) return null;
       int start = 0;
       while (rows > start * 2 && cols > start * 2) {
           printCircle(matrix, rows, cols, start, res);
           start++;
       }
       return res;
    }
    
    private void printCircle(int [][] matrix, int rows, int cols, int start, ArrayList<Integer> res) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        for (int i = start; i <= endX; i++) res.add(matrix[start][i]);
        if (endY > start) {
            for (int i = start+1; i <= endY; i++) res.add(matrix[i][endX]);
        }
        if (endX > start && endY > start) {
            for (int i = endX-1; i >= start; i--) res.add(matrix[endY][i]);
        }
        if (endX > start && endY > start + 1) {
            for (int i = endY-1; i >= start+1; i--) res.add(matrix[i][start]);
        }
    }
}