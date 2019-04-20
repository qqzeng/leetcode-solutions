/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    /**
        refer: https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
    
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = listLen(headA);
        int lenB = listLen(headB);
        boolean aGraterThanB = lenA > lenB;
        int dif = Math.abs(lenA - lenB);
        if (aGraterThanB) {
            while (dif-- > 0) headA = headA.next;
        } else {
            while (dif-- > 0) headB = headB.next;
        }
        while (headA != null && headB != null) {
            if (headA.val == headB.val) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
    
    private int listLen(ListNode head) {
        if (head == null) return 0;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
}