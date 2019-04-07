/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode p = prev.next;
        ListNode q = prev.next.next;
        while (p != null && q != null) {
            // 改变指针指向
            p.next = q.next;
            prev.next = q;
            // 向后传播
            prev = p;
            q.next = p;
            p = p.next;
            if (p != null) q = p.next;
        }
        return fakeHead.next;
    }
}