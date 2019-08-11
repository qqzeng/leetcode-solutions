import java.util.ArrayList;
public class Solution {

    // 不要忘记一个特例： array[p] == array[q] == array[mid]
    // 此时，不能确定中间的元素是属于前一个递增区域，还是后一个递增区域，因此，只能顺序遍历
    public int minNumberInRotateArray(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int p = 0;
        int q = array.length - 1;
        int mid = 0;
        while (array[p] >= array[q]) {
            if (q - p == 1) return array[q];
            mid = (p + q) / 2;

            if (array[p] == array[q] && array[p] == array[mid]) {
                return minInOrder(array, p, q);
            }

            if (array[p] <= array[mid]) {
                p = mid;
            } else if (array[q] >= array[mid]) {
                q = mid;
            }
        }
        return array[mid];
    }

    private int minInOrder(int[] array, int p, int q) {
        int result = array[p];
        for (int i = p + 1; i <= q; i++) {
            if (array[i] < result) {
                result = array[i];
            }
        }
        return result;
    }
}