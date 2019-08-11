public class Solution {
    
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int[] sum = new int[array.length];
        sum[0] = array[0];
        int max = sum[0];
        for (int i = 1; i < array.length; i++) {
            if (sum[i-1] > 0) {
                sum[i] += sum[i-1] + array[i];
            } else {
                sum[i] = array[i];
            }
            if (max < sum[i]) max = sum[i];
        }
        return max;
    }
    
    public int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int sum = array[0];
        int tmp = sum;
        for (int i = 1; i < array.length; i++) {
            if (tmp >= 0) {
                tmp += array[i];
            } else {
                tmp = array[i];
            }
            if (tmp > sum) {
                    sum = tmp;
            }
        }
        return sum > tmp ? sum : tmp;
    }
}