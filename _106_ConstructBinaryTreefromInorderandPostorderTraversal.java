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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return bt(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode bt(int[] inorder, int s1, int e1, int[] postorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        TreeNode root = new TreeNode(postorder[e2]);
        int rootIndex = -1;
        for (int i = s1; i <= e1; i++) {
            if (inorder[i] == postorder[e2]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) throw new IllegalArgumentException("input illegal!");
        int leftLen = rootIndex - s1;
        if (leftLen > 0) {
            root.left = bt(inorder, s1, rootIndex - 1, postorder, s2, s2 + leftLen-1);
        }
        if (leftLen < e2 - s2 + 1 - 1) {
            root.right = bt(inorder, rootIndex + 1, e1, postorder, s2 + leftLen, e2-1);
        }
        return root;
    }
}