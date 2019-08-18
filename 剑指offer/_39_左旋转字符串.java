public class Solution {
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0) return str;
        if (n > str.length()) n = (n % str.length());
        if (n <= 0) return str;
        int len = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < len; i++) {
            chars[((i - n) + len) % len] = str.charAt(i);
        }
        return String.valueOf(chars);
    }
}