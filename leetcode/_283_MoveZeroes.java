class Solution {
    
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int m = nums.length;
        int index = 0;
        while (index < m && nums[index] != 0) index++;
        for (int i = index; i < m; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
                nums[i] = 0;
            }
        }
    }
    
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return ;
        int m = nums.length;
        for (int i = 1; i < m; i++) {
            if (nums[i] != 0) {
                int t = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] == 0) {
                    nums[j + 1] = nums[j];
                    j--;
                }
                nums[j+1] = t;
            }
        }
    }
}