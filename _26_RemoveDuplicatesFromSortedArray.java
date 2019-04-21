class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p =  0;
        int q = p + 1;
        while (q < nums.length) {
            while (q < nums.length && nums[q-1] == nums[q]) q++;
            if (q == nums.length) break;
            nums[p+1] = nums[q];
            p = p + 1;
            q++;
        }
        return p + 1;
    }
}