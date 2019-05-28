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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res  = new ArrayList<>();
        if (root == null) return res;
        btp(res, root, "");
        return res;
    }
    
    private void btp(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) res.add(path + root.val);
        if (root.left != null) btp(res, root.left, path + root.val + "->");
        if (root.right != null) btp(res, root.right, path + root.val + "->");
    }
}