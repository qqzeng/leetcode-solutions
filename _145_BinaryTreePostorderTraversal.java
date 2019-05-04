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
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);

        TreeNode prev = null;
        TreeNode cur = null;
        while (stack.size() > 0) {
            cur = stack.peek();
            if ((cur != null && cur.left == null && cur.right == null)
                    || (cur != null && prev != null && (cur.left == prev || cur.right == prev))) {
                cur = stack.pop();
                result.add(cur.val);
                prev = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        postorderTraversalRecursively(root, result);
        return result;
    }
    
    private void postorderTraversalRecursively(TreeNode root, List<Integer> result) {
        if (root.left != null) postorderTraversalRecursively(root.left, result);
        if (root.right != null) postorderTraversalRecursively(root.right, result);
        result.add(root.val);
    }
    
}