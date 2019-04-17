/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        Deque<Integer> s1 = new ArrayDeque<>();
        Deque<Integer> s2 = new ArrayDeque<>();
        
        ListNode p = l1;
        while (p != null) {
            s1.push(p.val);
            p = p.next;
        }
        
        ListNode q = l2;
        while (q != null) {
            s2.push(q.val);
            q = q.next;
        }
        
        ListNode node = new ListNode(0);
        int sum = 0;
        while (s1.size() > 0 || s2.size() > 0) {
            if (s1.size() > 0) sum += s1.pop();
            if (s2.size() > 0) sum += s2.pop();
            node.val = sum % 10;
            ListNode head = new ListNode(0);
            head.next = node;
            node = head;
            sum /= 10;
        }
        if (sum > 0) node.val = sum;
        return node.val == 0 ? node.next : node;
    }
}