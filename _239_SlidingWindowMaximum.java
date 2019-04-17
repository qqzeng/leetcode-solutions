/**
	refer: https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation
*/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            
            // 队列中最多只保留 k 个元素（通过检测队顶元素的值来实现）
            // queue.peek() == queue.peekFirst()
            if (!queue.isEmpty() && queue.peek() == i - k) 
                queue.poll();
            
            // 当往队列中新加元素时，从队尾开始移除那些小于被加元素的值
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) 
                queue.pollLast();
            
            // 往队列新加元素
            queue.offer(i);
            
            // 将当前队列中最大的元素（即队顶元素）添加到结果数组中
            if (i + 1 >= k) 
                res[i + 1 - k] = nums[queue.peek()];
        }
        
        return res;
    }
}