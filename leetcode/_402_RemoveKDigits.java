class Solution {
    public String removeKdigits(String num, int k) {
        // System.out.println(num + "--------" + k);
        if (num == null || num.length() == 0) return "";
        if (k >= num.length()) return "0";
        if (k == 0) return num;
        int i = 0;
        int max = num.charAt(i);
        i++;
        // remove any character containing '0'
        while (i < num.length() && num.charAt(i) == '0') i++;
        if (i >= num.length()) return "0";
        if (i > 1 & i < num.length()) return removeKdigits(num.substring(i), --k);
        
        int j = i;
        while (j < num.length()) {
            if (num.charAt(j) >= num.charAt(j-1)) j++;
            else break;
        }
        // System.out.println(j);
        return removeKdigits(num.substring(0, j-1) + num.substring(j), --k);
    }
}