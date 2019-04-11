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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode tn = root;
        while (queue.size() > 0 || tn != null) {
            if (tn != null) {
                while (tn != null) {
                    queue.push(tn);
                    tn = tn.left;
                } 
            } else {
                tn = queue.pop();
                k--;
                if (k == 0) return tn.val;
                tn = tn.right;
            }
        }
        return  -1;
    }
    
    
//     int val = Integer.MAX_VALUE;
//     int count = -1;
//     public int kthSmallest(TreeNode root, int k) {
//         if (root == null) return -1;
//         count = k;
//         helper(root);
//         return val;
//     }
    
//     private void helper(TreeNode root) {
//         if (root == null) return;
//         if (root.left != null) helper(root.left);
//         count -= 1;
//         if (count == 0) {
//             val = root.val;
//             return; 
//         }
//         if (root.right != null) helper(root.right);
//     }
}