import java.util.Stack;

public class Solution {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    
    public void push(int node) {
        mainStack.push(node);
        if (!minStack.isEmpty()) { // 注意判空
            if (node < minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        } else {
            minStack.push(node);
        }
    }
    
    public void pop() {
        mainStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int min() {
        return minStack.peek();
    }
}