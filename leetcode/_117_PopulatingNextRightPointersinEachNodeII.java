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
    // refer: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
    public Node connect1(Node root) {
        Node retRoot = root;
        while (root != null) {
            Node tmp = new Node(0, null, null, null);
            Node cur = tmp;
            while (root != null) {
                if (root.left != null) { 
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = tmp.next;
        }
        return retRoot;
    }
    
    // refer: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37828/O(1)-space-O(n)-complexity-Iterative-Solution
    public Node connect(Node root) {
        Node retRoot = root;
        Node cur = root;
        Node prev = null;
        Node head = null;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
        return retRoot;
    }
}