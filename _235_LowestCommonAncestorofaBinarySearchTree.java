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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || q == null || p == null) return null;
        
        TreeNode node = root;
        while (node != p && node != q) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            }
            else if (node.val > p.val && node.val < q.val || node.val < p.val && node.val > q.val) {
                return node;
            }
            else {
                node = node.right;
            }
        }
        return node;
    }
}