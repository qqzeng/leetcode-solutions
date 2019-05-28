class Solution {
    
	/**
		refer:	https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution
	*/
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return ;
        int m = nums.length;
        k = k % m;
        if (k == 0) return;
        int p = 0, q = m - 1;
        while (q - p + 1 >= 2 * k) {
            m = q - p + 1;
            for (int i = p; i <= p + k - 1; i++) {
                int j = i + (m - k);
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            p = p + k;
            q = q;
        }
        int n = q - p + 1 - k;
        if (n > 0) {
            for (int j = p; j <= p + n - 1; j++) {
                int t = nums[p];
                for (int i = p + 1; i <= q; i++) {
                    nums[i-1] = nums[i];
                }
                nums[q] = t;
            }
        }
    }
    
    public void rotate1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) return ;
        int m = nums.length;
        for (int i = 0; i < k; i++) {
            int t = nums[m-1];
            for (int j = m-1; j >= 1; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = t;
        }
    }
}