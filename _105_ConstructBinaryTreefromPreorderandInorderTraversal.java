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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) return null;
        return bt(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode bt(int[] preorder, int s1, int e1, int[] inorder, int s2, int e2) {
        if (s1 > e1 || s2 > e2) return null;
        TreeNode root = new TreeNode(preorder[s1]);
        int rootIndex = -1;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - s2;
        if (leftLength > 0)
            root.left = bt(preorder, s1+1, s1+1+leftLength-1, inorder, s2, rootIndex-1);
        if (leftLength < e1 - s1 + 1)
            root.right = bt(preorder, s1+1+leftLength, e1, inorder, rootIndex+1, inorder.length-1);
        return root;
    }
}