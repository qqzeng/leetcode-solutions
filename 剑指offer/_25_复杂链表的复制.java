/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
import java.util.HashMap;
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = null;
        RandomListNode tmp = null;
        RandomListNode tmp2 = pHead;
        // 1. 
        while (tmp2 != null) {
            tmp = new RandomListNode(tmp2.label);
            RandomListNode t = tmp2.next;
            tmp2.next = tmp;
            tmp.next = t;
            tmp2 = t;
        }
        // 2. 
        tmp2 = pHead;
        while (tmp2 != null) {
            RandomListNode t = tmp2.next;
            if (t == null) break;
            t.random = tmp2.random == null ? null : tmp2.random.next;
            tmp2 = t.next;
        }
        // 3. 
        tmp2 = pHead;
        head = tmp2.next;
        while (tmp2 != null) {
            RandomListNode cloneNode = tmp2.next;
            tmp2.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            tmp2 = tmp2.next;
        }
        return head;
    }
    
    
    public RandomListNode Clone2(RandomListNode pHead)
    {
        if (pHead == null) return null;
        RandomListNode head = null;
        RandomListNode tmp = null;
        RandomListNode cur = null;
        RandomListNode tmp2 = pHead;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        boolean isHead = true;
        while (tmp2 != null) {
            tmp = new RandomListNode(tmp2.label);
            map.put(tmp2, tmp);
            if (isHead) {
                head = cur = tmp;
                isHead = false;
            } else {
                cur.next = tmp;
                cur = cur.next;
            }
            tmp2 = tmp2.next;
        }
        tmp2 = pHead;
        cur = head;
        while (tmp2 != null) {
            cur.random = map.get(tmp2.random);
            tmp2 = tmp2.next;
            cur = cur.next;
        }
        return head;
    }
}