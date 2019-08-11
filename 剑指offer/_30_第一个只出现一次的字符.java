import java.util.Map;
import java.util.HashMap;
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> nums = new HashMap<>();
        for (char c : str.toCharArray()) {
            int k = nums.getOrDefault(c, 0);
            nums.put(c, k+1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (nums.getOrDefault(str.charAt(i), 0) == 1) {
                return i;
            }
        }
        return -1;
    }
}