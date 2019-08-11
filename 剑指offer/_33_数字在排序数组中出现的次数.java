public class Solution {
    public int GetNumberOfK(int [] array , int k) {
       if (array == null || array.length == 0) return 0;
        // first occurance
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (array[mid] >= k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        if (j + 1 > array.length - 1) return 0;
        int firstIndex = array[j + 1] == k ? j + 1 : -1;
        if (firstIndex == -1) return 0;
        // last occurance
        i = 0;
        j = array.length - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (array[mid] > k) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        int lastIndex = array[i - 1] == k ? i - 1 : -1;
        return lastIndex - firstIndex + 1;
    }
}