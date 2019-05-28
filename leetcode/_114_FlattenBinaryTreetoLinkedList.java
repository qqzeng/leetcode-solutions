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
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode node = root;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (stack.size() > 0 || node != null) {
            if (node != null) {
                while (node != null) {
                    queue.offer(node);
                    stack.push(node);
                    node = node.left;
                }
            }
            if (stack.size() > 0 ) {
                node = stack.pop();
                node = node.right;
            }
        }
        node = root = queue.poll();
        while (queue.size() > 0) {
            node.right = queue.poll();
            node.left = null;
            node = node.right;
        }
    }
}