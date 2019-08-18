/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    
    public ListNode ReverseListHelper(ListNode node) {
        if (node == null || node.next == null) return node;
        else{
            ListNode newRoot = ReverseListHelper(node.next);
            node.next.next=node;
            node.next=null;
            return newRoot;
        }
    }
    
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        return ReverseListHelper(head);
    }
    
    public ListNode ReverseList4(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }
        cur.next = prev;
        return cur;
    }
}