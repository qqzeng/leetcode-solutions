/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/
import java.util.Stack;
import java.util.ArrayList;
public class Solution {
    
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) return new ArrayList<Integer>();
        ArrayList<Integer> resList = new ArrayList<>();
        reverseListRecursively(listNode, resList);
        return resList;
    }
 
    public void reverseListRecursively(ListNode listNode, ArrayList<Integer> resList) {
        if (listNode == null) return ;
        reverseListRecursively(listNode.next, resList);
        resList.add(listNode.val);
        return ;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) return result;
        ListNode newRoot = helper(result, listNode);
        while (newRoot != null) {
            result.add(newRoot.val);
            newRoot = newRoot.next;
        }
        return result;
    }
    
    private ListNode helper(ArrayList<Integer> result, ListNode root) {
        if (root == null || root.next == null) return root;
        ListNode newRoot = helper(result, root.next);
        root.next.next = root;
        root.next = null;
        return newRoot;
    }
    
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode == null) return new ArrayList<Integer>();
        ArrayList<Integer> resList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            resList.add(stack.pop());
        }
        return resList;
    }
}