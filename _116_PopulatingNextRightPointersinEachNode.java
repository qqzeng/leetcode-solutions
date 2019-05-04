/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    
    // refer: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37472/A-simple-accepted-solution
    public Node connect(Node root) {
        if (root == null) return root;
        dfs(root, null);                
        return root;
    }
    
    private void dfs(Node cur, Node next) {
        if (cur == null) return;
        cur.next = next;
        dfs(cur.left, cur.right);
        dfs(cur.right, cur.next == null ? null : cur.next.left);
    }
    
    // O(n)
    public Node connect2(Node root) {
        if (root == null) return root;
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        Node node = null;
        int curNum = 1;
        int nextNum = 0;
        int i = 0;
        while (queue.size() > 0 && curNum > 0) {
            i = 0;
            while (i < curNum) {
                if (i >= 1) {
                    node.next = queue.poll();
                    node = node.next;
                }
                else node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    nextNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    nextNum++;
                }
                i++;
            }
            curNum = nextNum;
            nextNum = 0;
        }
        return root;
    }
}