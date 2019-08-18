import java.util.Arrays;
public class Solution {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        boolean success = true;
        int zeroCount = 0;
        int gapCount = 0;
        int i = 0;
        while (numbers[i] == 0) i++;
        zeroCount = i; // 统计 0 的个数
        for (; i < numbers.length; i++) {
            // 包含相同的数字
            if ((i <= numbers.length - 2) && (numbers[i] == numbers[i + 1])) {
                success = false;
                break;
            }
            // 统计间隔
            if (i <= numbers.length - 2) gapCount += numbers[i+1] - numbers[i] - 1;
        }
        
        if (gapCount > zeroCount) return false;
        return success;
    }
}