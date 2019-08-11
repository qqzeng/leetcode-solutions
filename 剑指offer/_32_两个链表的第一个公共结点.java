/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
     // 还可以用栈
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        int len1 = 1;
        while (p1 != null) { p1 = p1.next; len1++;}
        ListNode p2 = pHead2;
        int len2 = 1;
        while (p2 != null) {p2 = p2.next; len2++;}
        p1 = pHead1;
        p2 = pHead2;
        if (len1 > len2) {
            int dif = len1 - len2;
            while (--dif >= 0) {
                p1 = p1.next;
            }
        } else {
            int dif = len2 - len1;
            while (--dif >= 0) {
                p2 = p2.next;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == null ? null : p1;
    }
}