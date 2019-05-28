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
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                if (prev != null && prev.val >= node.val) return false;
                prev = node;
                node = node.right;
            }
        }
        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}