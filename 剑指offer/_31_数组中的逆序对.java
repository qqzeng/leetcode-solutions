import java.util.Arrays;
public class Solution {
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0) return -1;
        int[] copy = Arrays.copyOf(array, array.length);
        long count = inversePairCore(array, copy, 0, array.length - 1);
        return (int)(count % 1000000007);
    }
    
    private long inversePairCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = array[start];
            return 0;
        }
        
        int len = (end - start) / 2;
        long leftCount = inversePairCore(copy, array, start, start + len);
        long rightCount = inversePairCore(copy, array, start + len + 1, end);
        int i = start + len;
        int j = end;
        long count = 0;
        int mergeIndex = end;
        while (i >= start && j >= start + len + 1) {
            if (array[i] > array[j]) {
                count += (j - start - len);
                copy[mergeIndex--] = array[i--];
            } else {
                copy[mergeIndex--] = array[j--];
            }
        }
        for (; i >= start; i--) copy[mergeIndex--] = array[i];
        for (; j >= start + len + 1; j--) copy[mergeIndex--] = array[j];
        return (leftCount + rightCount + count) % 1000000007;
    }
}