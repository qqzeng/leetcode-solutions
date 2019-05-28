class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int m = height.length - 1;
        int left = 0, right = m;
        int max = Math.min(height[right], height[left]) * (right - left);
        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
            max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
        }
        return max;
    }
}