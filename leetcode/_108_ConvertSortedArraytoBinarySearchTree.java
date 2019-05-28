/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
    
    private TreeNode helper(int[] nums, int s, int e) {
        if (e < s) return null;
        int rootIndex = (e+s)/2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = helper(nums, s, rootIndex-1);
        root.right = helper(nums, rootIndex + 1, e);
        return root;
    }
}