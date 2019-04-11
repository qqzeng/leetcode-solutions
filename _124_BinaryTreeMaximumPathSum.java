/**
	refer: https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39775/Accepted-short-solution-in-Java
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int max = Integer.MIN_VALUE;
    
//     public int maxPathSum(TreeNode root) {
//         helper(root);
//         return max;
//     }
    
//     private int helper(TreeNode root) {
//         if(root == null) return 0;
//         int left = Math.max(helper(root.left), 0);
//         int right = Math.max(helper(root.right), 0);
//         max = Math.max(max, root.val + left + right);
//         return root.val + Math.max(left, right);
//     }
    
//     private int maxVal = Integer.MIN_VALUE;
 
// 	public int maxPathSum(TreeNode root) {
// 		if (root == null)
// 			return 0;
// 		maxCore(root);
// 		return maxVal;
// 	}
 
// 	// 该函数返回是左右的最大路径和，而非左+右+root的最大值
// 	// 使用curValue，来标记左+右+root
// 	private int maxCore(TreeNode root) {
// 		if (root == null)
// 			return 0;
// 		// 求以root为根的当前子树的最大路径和
// 		// 如果左右子树都是负数，
// 		// 那么就最大路径就是当前结点值（无论正负）
// 		int curValue = root.val;
// 		int lmax = maxCore(root.left);
// 		int rmax = maxCore(root.right);
// 		if (lmax > 0)
// 			curValue += lmax;
// 		if (rmax > 0)
// 			curValue += rmax;
// 		maxVal = Math.max(curValue, maxVal);
// 		// 返回以当前root为根的子树的最大路径和
// 		// 左右有可能都为负数，所以需要参与比较大小
// 		int thisMax = Math.max(root.val, 
// 				Math.max(lmax + root.val, 
// 						rmax + root.val));
// 		return thisMax;
// 	}
    
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        backtrack(root);
        return max;
    }
    private int backtrack(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        int left = backtrack(root.left);
        int right = backtrack(root.right);
        max = Math.max(max,Math.max(right,left));       //pick left branch or right branch
        max = Math.max(max,root.val);                   //pick root
        max = Math.max(max,root.val+Math.max(0,left)+ Math.max(0,right)  ); // pick root + MAX(0,left) + MAX(0,right)
        return root.val + Math.max(0,Math.max(left,right));
    }
}