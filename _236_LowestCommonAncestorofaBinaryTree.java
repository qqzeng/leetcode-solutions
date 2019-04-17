/**
	refer: https://blog.csdn.net/sgbfblog/article/details/7935537
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

class Solution {
    
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root; // 一旦发现当前节点等于 p 或者 q，则返回
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left != null && right != null) return root; // 若递归查找时，在左子树与右子树都能找到，则其公共祖先为root.
        return left == null ? right : left; // 否则，若在左子树中查找结果不为空，则左子树查找返回的节点即为公共祖先；右子树类似。
    }
    
    /******************************************************************************************************/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (hasNode(root.left, p) && hasNode(root.left, q)) { // 若都在左子树中，则递归向左子树中查找
            return lowestCommonAncestor(root.left, p, q);
        }
        if (hasNode(root.right, p) && hasNode(root.right, q)) { // 若都在右子树中，则递归向左子树中查找
            return lowestCommonAncestor(root.right, p, q);
        }
        return root; // 否则表示一个在左子树，一个在右子树，则返回根节点
    }
    
    private boolean hasNode(TreeNode root, TreeNode node) {
        if (root == null) return false;
        if (root == node) return true;
        return hasNode(root.left, node) || hasNode(root.right, node);
    }
    
    /******************************************************************************************************/
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // 获取包含 p 的二叉树的路径，以根节点为起点，p为终点
        List<TreeNode> nodePath = new ArrayList<>();
        nodePath.add(root);
        helper(nodePath, root, p);
        List<TreeNode> pathP = path;
        
        // 获取包含 q 的二叉树的路径，以根节点为起点，q为终点
        nodePath = new ArrayList<>();
        nodePath.add(root);
        helper(nodePath, root, q);
        List<TreeNode> pathQ = path;
        
        // 顺序遍历两个路径，找到第一个不同的节点，则其上一个节点（最后一个相同的节点）即为最小公共祖先
        int i = 0, j = 0;
        while (i < pathP.size() && j < pathQ.size()) {
            if (pathP.get(i) == pathQ.get(j)) {
                i++;
                j++;
                continue;
            } else break;
        }
        if (i != pathP.size() && j != pathQ.size()) return pathP.get(i-1);
        if (i == pathP.size()) return pathP.get(pathP.size()-1);
        if (i == pathQ.size()) return pathQ.get(pathQ.size()-1);
        return null;
    }
    
    List<TreeNode> path = new ArrayList<>();
    private void helper(List<TreeNode> nodePath, TreeNode root, TreeNode node) {
        if (root.val == node.val) {
            path = new ArrayList<>(nodePath);
            return ;
        }
        
        if (root.left != null) {
            nodePath.add(root.left);
            helper(nodePath, root.left, node);
            nodePath.remove(nodePath.size()-1);
        }
        
        if (root.right != null) {
            nodePath.add(root.right);
            helper(nodePath, root.right, node);
            nodePath.remove(nodePath.size()-1);
        }
    }
}