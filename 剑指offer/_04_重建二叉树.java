/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || in == null) return null;
        return constructCoreRecursively(pre, 0, pre.length-1, in, 0, in.length-1);
    }
    
    public TreeNode constructCoreRecursively(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        TreeNode root = new TreeNode(pre[startPre]);
        if (startPre == endPre) return root;
        
        int rootIndex = -1;
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == root.val) {
                rootIndex = i;
            }
        }
        if (rootIndex == -1) throw new IllegalArgumentException("input illegal!");
        int leftLength = rootIndex - startIn;
        if (leftLength > 0) {
            root.left = constructCoreRecursively(pre, startPre+1, startPre+1+leftLength-1, in, startIn, rootIndex-1);
        }
        if (leftLength < endPre - startPre + 1 -1) {
            root.right = constructCoreRecursively(pre, startPre+1+leftLength, endPre, in, rootIndex+1, endIn);
        }
        return root;
    }
}