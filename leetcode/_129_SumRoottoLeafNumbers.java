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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> resStr = new ArrayList<>();
        helper(root, resStr, "");
        int sum = 0;
        for (String str : resStr) sum += Integer.valueOf(str);
        return sum;
    }
    
    private void helper(TreeNode root, List<String> resStr, String str) {
        if (root.left == null && root.right == null) {
            resStr.add(str+root.val);
            return;
        }
        if (root.left != null) helper(root.left, resStr, str + root.val);
        if (root.right != null) helper(root.right, resStr, str + root.val);
    }
}