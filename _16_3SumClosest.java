class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int m = nums.length;
        int tmpRes = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < m - 2; i++) {
            int low = i + 1;
            int high = m - 1;
            while (low < high) {
                int tmpSum = nums[i] + nums[low] + nums[high];
                if (tmpSum < target) {
                    low++;
                } else if (tmpSum > target) {
                    high--;
                } else 
                    return target;
                if (Math.abs(tmpSum - target) < Math.abs(tmpRes - target)) {
                    tmpRes = tmpSum;
                }
            }
        }
        return tmpRes;
    }
}