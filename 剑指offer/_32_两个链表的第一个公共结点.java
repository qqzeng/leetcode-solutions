/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {

     // 如果可以事先知道两个链表的长度，则让长的链表先走二者的差值，然后，再同时走，会交于同一个节点

     // 还可以两个指针分别遍历两个链表，当某一个指针遍历完成后，就重新设置为另一个链表的表头，这样二者最终会相交于一个节点
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