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
        // quickSort(head, null);
        // return head;
        return mergeSort(head);
    }
    
	// refer: https://blog.csdn.net/otuhacker/article/details/10366563
    public void quickSort(ListNode head, ListNode tail) {
        if (head != tail) {
            ListNode pivot = partition(head, tail);
            quickSort(head, pivot);
            quickSort(pivot.next, tail);
        }
    }
    
    public ListNode partition(ListNode low, ListNode high) {
        int key = low.val;
        ListNode p = low;
        ListNode q = low.next;
        while (q != high) {
            if (q.val < key) {
                p = p.next;
                int tmp = p.val;
                p.val = q.val;
                q.val = tmp;
            }
            q = q.next;
        }
        int tmp = low.val;
        low.val = p.val;
        p.val = tmp;
        return p;
    }
    
    public ListNode mergeSort(ListNode head) {
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