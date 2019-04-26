class Solution {
    public int arrayPairSum1(int[] nums) {
        int MAX_ARRAY_SIZE = 10000;
        int [] a = new int[2 * MAX_ARRAY_SIZE + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            a[MAX_ARRAY_SIZE + nums[i]] += 1;
        }
        int j = 0;
        for (int i = 0; i < 2 * MAX_ARRAY_SIZE && j < nums.length; i++) {
            if (a[i] != 0) {
                int k = 0;
                while (k++ < a[i]) {
                    if (j % 2 == 0) {
                        sum += i - MAX_ARRAY_SIZE;
                    }
                    j++;
                }
            }
        }
        return sum;
    }
    
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}