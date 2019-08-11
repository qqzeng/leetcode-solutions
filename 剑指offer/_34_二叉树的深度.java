/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
*/
import java.util.ArrayDeque;
public class Solution {
    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int depth = 0;
        while(queue.size() > 0) {
            int s = queue.size();
            depth++;
            while(s-- > 0) {
                TreeNode tn= queue.poll();
                if (tn.left != null) queue.offer(tn.left);
                if (tn.right != null) queue.offer(tn.right);
            }
        }
        return depth;
    }
    
    
    public int TreeDepth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right))+1;
    }
}