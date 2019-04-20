/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList1(ListNode head) {
        if (head == null ) return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        ListNode newHead = null;
        while (cur != null) {
            cur.next = prev;
            prev = cur;
            if (next == null) newHead = prev;
            cur = next;
            if (next != null)
                next = next.next;
        }
        return newHead;
    }
    
    
    public ListNode reverseList(ListNode head) {
        if (head == null ) return head;
        return reverseListRecursively(head);
    }
    
    private ListNode reverseListRecursively(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        // p is the newHead
        return newHead;
    }
}