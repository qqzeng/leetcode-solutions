/**
 *
 * 简析： 比较有意思的一道题。O(lgn)的复杂度的排序算法有：快排（O(1)空间），堆排（O(1)），归并（O(n)）。
 *     关于归并排序，对于链表来说可以通过改变指针的指向可以避免申请辅助空间。因此，可以考虑使用归并排序实现。
 *     关键点在于链表的一个"归"的过程，即链表分割过程。使用两个指针的方式。
 *
 *     若为双链表，则使用快排也较为方便。
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode t = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                t.next = l1;
                l1 = l1.next;
            } else {
                t.next = l2;
                l2 = l2.next;
            }
            t = t.next;
        }
        if (l1 != null) {
            t.next = l1;
        }
        if (l2 != null) {
            t.next = l2;
        }
        return newHead.next;
    }
}