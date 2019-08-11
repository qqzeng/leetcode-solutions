public class Solution {
    boolean balanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        getDepth(root);
        return balanced;
    }
    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftH = getDepth(root.left);
        int rightH = getDepth(root.right);
        if (Math.abs(leftH-rightH) > 1) {
            balanced = false;
            return -1;
        }
        return Math.max(leftH, rightH)+1;
    }
    
    
    
    public boolean IsBalanced_Solution1(TreeNode root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if( Math.abs(left-right) > 1) return false;
        else return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }
            
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH, rightH) + 1;
    }
}