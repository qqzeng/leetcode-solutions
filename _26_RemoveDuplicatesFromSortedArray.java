/**
	注意边界条件。
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = p + 1;
        while (true) {
            while (q < nums.length && p < nums.length-1 && nums[p] == nums[q]) q++;
            if (p + 1 < nums.length && q < nums.length) nums[p+1] = nums[q];
            else break;
            p++;
            if (p == q) q++;
        }
        return p+1;
    }
}