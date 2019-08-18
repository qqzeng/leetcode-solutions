public class Solution {
    public String ReverseSentence(String str) {
        if (str == null || str.length() == 0) return str;
        char[] chs = str.toCharArray();
        reverse(chs, 0, chs.length - 1);
        int begin = 0;
        int i = 0;
        for (i = 0; i < chs.length; i++) {
            if (chs[i] == ' ') {
                reverse(chs, begin, i - 1);
                begin = i + 1;
            }
        }
        reverse(chs, begin, i - 1);
        return String.valueOf(chs);
    }
    
    private void reverse(char[] chs, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char tmp = chs[j];
            chs[j] = chs[i];
            chs[i] = tmp;
            i++; j--;
        }
    }
}