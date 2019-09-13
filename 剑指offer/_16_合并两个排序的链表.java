/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    
    public ListNode Merge(ListNode list1,ListNode list2) {
        // return MergeIterative(list1, list2);
        return MergeRecursively(list1, list2);
    }
    
    public ListNode MergeIterative(ListNode list1,ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode head = new ListNode(-1);
        ListNode curNode = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                curNode.next = p;
                p = p.next;
            } else {
                curNode.next = q;
                q = q.next;
            }
            curNode = curNode.next;
        }
        if (p == null) curNode.next = q;
        if (q == null) curNode.next = p;
        return head.next;
    }
    
    public ListNode MergeRecursively(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null && list2 != null) return list2;
        if (list1 != null && list2 == null) return list1;
        ListNode newHead = null;
        if (list1.val <= list2.val) {
            newHead = list1;
            list1 = list1.next;
        } else {
            newHead = list2;
            list2 = list2.next;
        }
        newHead.next = MergeRecursively(list1, list2);
        return newHead;
    }
}