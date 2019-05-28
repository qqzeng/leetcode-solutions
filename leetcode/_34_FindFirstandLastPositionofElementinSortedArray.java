class Solution {
    public int[] searchRange1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right= nums.length-1;
        int first = -1;
        int last = -1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                while(mid >= 0 && nums[mid] == target) mid--;
                first = mid+1;
                mid++;
                while (mid <= nums.length-1 && nums[mid] == target) mid++;
                last = mid-1;
                return new int[]{first, last};
            }
            else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{-1, -1}; 
    }
    
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int left = 0;
        int right= nums.length-1;
        // 在[0, lenght-1]中找第一次出现的位置 first_i
        while(left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] >= target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        if (right + 1 > nums.length-1) return new int[]{-1, -1};
        int first = nums[right + 1] == target ? right + 1 : -1;
        if (first == -1) return new int[]{-1, -1};
        left = first;
        right = nums.length - 1;
        // 在[first_i, lenght-1]中找最后一次出现的位置 last_i
        while(left <= right) {
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target)
                right = middle - 1;
            else
                left = middle + 1;
        }
        int last = nums[left - 1] == target ? left - 1 : -1;
        return new int[]{first, last};
    }
}