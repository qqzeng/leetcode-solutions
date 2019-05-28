class Solution {
    public boolean isHappy1(int n) {
        if (n == 1) return true;
        HashMap<Integer, Boolean> memo = new HashMap<>();
        memo.put(n, true);
        while (true) {
            int t = 0;
            String str = n + "";
            for (int i = 0; i < str.length(); i++) {
                t += (str.charAt(i) - '0') * (str.charAt(i) - '0');
            }
            if (t == 1) {
                return true;
            }
            if (memo.containsKey(t)) {
                return false;
            }
            memo.put(t, true);
            n = t;
        }
    }
    
    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Integer> memo = new HashSet<>();
        while (memo.add(n)) { // return false if present
            int t = 0;
            String str = n + "";
            for (int i = 0; i < str.length(); i++) {
                t += (str.charAt(i) - '0') * (str.charAt(i) - '0');
            }
            if (t == 1) {
                return true;
            }
            n = t;
        }
        return false;
    }
}