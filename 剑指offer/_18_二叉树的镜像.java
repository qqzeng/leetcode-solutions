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
    public void Mirror(TreeNode root) {
        if (root == null) return ;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }

    public void Mirror2(TreeNode root) {
        if (root == null) return ;
        ArrayDeque<TreeNode> iterNodeQueue = new ArrayDeque<>();
        iterNodeQueue.push(root);
        TreeNode tn = null;
        while (!iterNodeQueue.isEmpty()) {
            tn  = iterNodeQueue.pop();
            if (tn.left != null || tn.right != null) {
                TreeNode left = tn.left;
                tn.left = tn.right;
                tn.right = left;
                if (tn.left != null) iterNodeQueue.push(tn.left);
                if (tn.right != null) iterNodeQueue.push(tn.right);
            }
        }
    }
}