class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int i = 0;
        int len = 0;
        while (true) {
            if (i >= strs[0].length()) break;
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) return strs[j].substring(0, i);
                if (c != strs[j].charAt(i)) return strs[j].substring(0, i);
            }
            i++;
        }
        return strs[0].substring(0, i);
    }
}