public class Solution {
    public String replaceSpace(StringBuffer str) {
        if (str == null || str.equals("")) return "";
        char[] strChar = str.toString().toCharArray();
        int spaceNum = 0;
        for (char c : strChar) {
            if (c == ' ') spaceNum++; 
        }
        int newLen = strChar.length + 2 * spaceNum;
        char[] newStrChar = new char[newLen];
        int j = newLen - 1;
        for (int i = strChar.length - 1; i >= 0; i--) {
            if (strChar[i] == ' ') {
                newStrChar[j--] = '0';
                newStrChar[j--] = '2';
                newStrChar[j--] = '%';
            } else {
                newStrChar[j--] = strChar[i];
            }
        }
        return new String(newStrChar);
    }
}