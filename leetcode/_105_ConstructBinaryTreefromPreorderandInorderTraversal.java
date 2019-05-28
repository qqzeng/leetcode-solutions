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
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return bt(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    private TreeNode bt(int[] preorder, int startPre, int endPre, int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(preorder[startPre]);
        
        int rootIndex = -1;
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startPre]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) throw new RuntimeException();
        
        int leftLen = rootIndex - 1 - startIn + 1;
        if (leftLen > 0) {
            root.left = bt(preorder, startPre + 1, startPre + 1 + leftLen - 1, inorder, startIn, rootIndex - 1);
        }
        
        if (leftLen < endPre - startPre + 1) {
            root.right = bt(preorder, startPre + 1 + leftLen, endPre, inorder, rootIndex + 1, endIn);
        }
        
        return root;
    }
}