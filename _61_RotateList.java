/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) return head;
        int m = 0;
        ListNode p = head;
        while(p != null) {
            m++;
            p = p.next;
        }
        int n = k % m;
        if (n == 0) return head;
        p = head;
        ListNode q = head;
        ListNode s = null;
        while (n-- > 0) p = p.next;
        while (p != null) {
            p = p.next;
            if (p == null) {
                s = q;
            }
            q = q.next;
        }
        if (s != null) s.next = null;
        ListNode newHead = q;
        while (q.next != null) q = q.next;
        //System.out.println("-----");
        q.next = head;
        return newHead;
    }
}