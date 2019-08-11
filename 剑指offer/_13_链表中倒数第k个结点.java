/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null) return head;
        if (k == 0) return null;
        ListNode prev = head;
        ListNode behind = head;
        int m = k - 1;
        while (m-- > 0) {
            if (prev.next != null) prev = prev.next;
            else return null;
        }
        while (prev.next != null) {
            prev = prev.next;
            behind = behind.next;
        }
        return behind;
    }
}