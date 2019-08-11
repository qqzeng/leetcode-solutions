public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return -1;
        partition(array, 0, array.length - 1);
        return checkMoreThanHalf(array, array[array.length/2]) ? array[array.length/2] : 0;
    }
    
    private void partition(int[] array, int low, int high) {
        int i = low;
        int j = high;
        int tmp = array[i];
        while (i < j) {
            while (i < j && array[j] >= tmp) j--;
            array[i] = array[j];
            while (i < j && array[i] <= tmp) i++;
            array[j] = array[i];
        }
        array[i] = tmp;
    }
    
    
    private boolean checkMoreThanHalf(int[] array, int num) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                k++;
            }
        }
        return k > array.length / 2;
    }
    
    public int MoreThanHalfNum_Solution1(int [] array) {
        if (array == null || array.length == 0) return -1;
        int count = 1;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count = 1;
            } else if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return checkMoreThanHalf(array, num) ? num : 0;
    }
}