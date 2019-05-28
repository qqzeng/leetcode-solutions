class Solution {
	public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int m = nums.length;
        int t = 0;
        int max = 0;
        int maxIndex = m - 1;
        for (int i = m - 2; i >= 0; i--) {
            t = nums[i] - (curIndex - i);
            max = Math.max(cur, t);
            if (t >= 0) {
                maxIndex = i;                
            }
        }
        return max >= 0 && maxIndex == 0; 
    }
	
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int i = 0;
        int count = 1;
        if (nums[0] == 0 && nums.length > 1) return false;
        boolean flag = false;
        int j = -1;
        int s = 0;
        while (i < nums.length-1) {
            int curSpan = nums[i];
            j = i + 1;
            s = 0;
            flag = false;
            while (j < nums.length-1 && j <= curSpan + i) {
                s += nums[j];
                if (s >= curSpan) {
                    flag = true; break;
                }
                j++;
            }
            count++;
            if (j < nums.length -1 && nums[j-1] == 0 && !flag) return false;            // 在中间遇到 0
            if (j >= nums.length -1 && nums[j-1] == 0 && s < nums.length-i-1 && curSpan < nums.length-i-1) return false;// 倒数第二个是0
            
            if (!flag) i = curSpan + i; // 有更大的 span
            else i = j; // 直接跳 curSpan
        }
        return true;
    }
	
	// refer: https://leetcode.com/problems/jump-game/discuss/20900/Simplest-O(N)-solution-with-constant-space comment 1.
	public boolean canJump2(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        int max = nums[0];
        int curMax = 0;
        int i = 1;
        while (i < nums.length) {
            if (max < i) return false;
            curMax = nums[i] + i;
            if (curMax > max) max = curMax;
            if(max >= nums.length - 1) return true; // optimize
            i++;
        }
        return true;
    }
}


