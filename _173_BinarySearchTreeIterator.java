/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// refer : https://leetcode.com/problems/binary-search-tree-iterator/discuss/52525/My-solutions-in-3-languages-with-Stack
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushAllLeftToStack(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAllLeftToStack(tmpNode.right);
        return tmpNode.val;
    }
    
    private void pushAllLeftToStack(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
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
class LinkedTreeNode{
    TreeNode node;
    LinkedTreeNode next;
    public LinkedTreeNode(){}
    public LinkedTreeNode(TreeNode node) {this.node = node;}
}
class BSTIterator {

    LinkedTreeNode head;
    LinkedTreeNode cur;
    
    public BSTIterator(TreeNode root) {
        
        LinkedTreeNode tmp = null;
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            if (stack.size() > 0) {
                node = stack.pop();
                if (head == null) {
                    head = new LinkedTreeNode(node);
                    tmp = cur = head;
                } else {
                    tmp.next = new LinkedTreeNode(node);
                    tmp = tmp.next;
                }
                node = node.right;
            }
        }
        
    }
    
    /** @return the next smallest number */
    public int next() {
        if (cur == null) return -1;
        LinkedTreeNode result = cur;
        cur = cur.next;
        return result.node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */