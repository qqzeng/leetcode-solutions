class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.equals("")||t.equals("")) return "";
        // Calculate number of all characters in t
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int count = dict.getOrDefault(t.charAt(i), 0);
            dict.put(t.charAt(i), count+1);
        }
        // number of characters in current window
        HashMap<Character, Integer> windowCounts = new HashMap<>(); 
        int dinstinctCount = 0; // number of dinstinct character in currentWindow which is desired
        int totalCount = dict.size(); // total number of dinstinct character desired
        int[] ans = {-1, 0, 0}; // answer: length, left, right
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count+1);
            if (dict.containsKey(c) && windowCounts.get(c).intValue() == dict.get(c).intValue()) {
                dinstinctCount++;
            }
            while (l <= r && dinstinctCount == totalCount) {
                char ch = s.charAt(l);
                if (ans[0] == -1 || ans[0] > r -l + 1) { // update the smallest window parameter.
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }
                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if (dict.containsKey(ch) && windowCounts.get(ch).intValue() < dict.get(ch).intValue()){
                    dinstinctCount--;
                }
                l++;
            }
            r++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}