class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curMax = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) tmp++;
            else {
                curMax = Math.max(curMax, tmp);
                tmp = 0;
            }
        }
        return Math.max(curMax, tmp);
    }
}