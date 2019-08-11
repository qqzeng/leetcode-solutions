public class Solution {
    public void reOrderArray(int [] array) {
        if (array ==  null || array.length <= 1) return ;
        for (int i = 1; i < array.length; i++) {
            if ((array[i] & 0x1) == 1) {
                int j = i - 1;
                int tmp = array[i];
                while (j >= 0 && (array[j] & 0x1) == 0) {
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = tmp;
            }
        }
        return ;
    }
}