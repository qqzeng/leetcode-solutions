public class Solution {
    public boolean Find(int target, int [][] array) {
        int r = array.length - 1;
        int c = array[0].length - 1;
        int cr = 0;
        int cc = c;
        while (cr >= 0 && cr <= r && cc >= 0 && cc <= c) {
            if (target > array[cr][cc]) {
                cr += 1;
            } else if (target < array[cr][cc]) {
                cc -= 1;
            } else 
                return true;
        }
        return false;
    }
}