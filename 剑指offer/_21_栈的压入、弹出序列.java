import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null) return false;
        if (pushA.length == 0 || popA.length == 0) return false;
        if (pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        stack.push(pushA[index]);
        index++;
        for (int i = 0; i < popA.length;) {
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                i++;
                stack.pop();
            } else if (index <= pushA.length-1 && stack.peek() != popA[i]) {
                while (index <= pushA.length-1 && stack.peek() != popA[i]) {
                    System.out.println(pushA[index]);
                    stack.push(pushA[index++]);
                }
            } else {
                if (index == pushA.length) return false;
            }
        }
        return true;
    }
}