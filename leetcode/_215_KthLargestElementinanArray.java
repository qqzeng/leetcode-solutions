class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int n : nums) {
            queue.offer(n);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
    
    
    
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) return -1;
        int start = 0;
        int end = nums.length - 1;
        return findKthLargetNumber(nums, start, end, nums.length - k + 1);
    }
    
    private int findKthLargetNumber(int[] nums, int start, int end, int k) {
        if (start > end) return -1;
        int pivot = partition(nums, start, end);
        if (pivot + 1 == k) {
            return nums[pivot];
        } else if (pivot + 1 < k) {
            return findKthLargetNumber(nums, pivot + 1, end, k);
        } else {
            return findKthLargetNumber(nums, start, pivot - 1, k);
        }
    }
    
    private int partition(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int tmp = nums[start];
        
        while (i < j) {
            while (i < j && nums[j] >= tmp) j--; 
            nums[i] = nums[j];
            while (i < j && nums[i] <= tmp) i++;
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        return i;
    }
}