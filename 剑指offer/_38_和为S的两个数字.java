import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || array.length == 0) return res;
        int i = 0; 
        int j = array.length - 1;
        while (i < j) {
            if (sum - array[i] > array[j]) {
                i++;
            } else if (sum - array[i] < array[j]) {
                j--;
            } else {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
        }
        return res;
    }
}