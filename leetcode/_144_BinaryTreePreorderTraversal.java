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
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                while (node != null) {
                    stack.push(node);
                    result.add(node.val);
                    node = node.left;
                }
            }
            
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        preorderTraversalRecursively(root, result);
        return result;
    }
    
    private void preorderTraversalRecursively(TreeNode root, List<Integer> result) {
        result.add(root.val);
        if (root.left != null) preorderTraversalRecursively(root.left, result);
        if (root.right != null) preorderTraversalRecursively(root.right, result);
    }
}