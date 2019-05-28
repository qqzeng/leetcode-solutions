class Solution {
    public int maxSubArray1(int[] nums) {
        // maxSubArray(A, i) = (maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0) + A[i]; 
        int[] maxSubArray = new int[nums.length];
        maxSubArray[0] = nums[0];
        int max = maxSubArray[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxSubArray[i-1] > 0)
                maxSubArray[i] = maxSubArray[i-1] + nums[i];
            else 
                maxSubArray[i] = nums[i];
            if (max < maxSubArray[i]) {
                max = maxSubArray[i];
            }
        }
        return max;
    }
    
    //  每次元素累加和小于0时，从下一个元素重新开始累加。
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int m = nums.length;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0)
                curSum = 0;
        }
        return maxSum;
    }
}