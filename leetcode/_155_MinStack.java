class MinStack {

    private Stack<Integer> sMain;
    private Stack<Integer> sMin;
    /** initialize your data structure here. */
    public MinStack() {
        sMain = new Stack<>();
        sMin = new Stack<>();
    }
    
    public void push(int x) {
        sMain.push(x);
        if (!sMin.empty()) {
            int curMin = sMin.peek();
            if (curMin > x) {
                sMin.push(x);
            } else {
                sMin.push(curMin);
            }
        } else {
            sMin.push(x);
        }
    }
    
    public void pop() {
        sMain.pop();
        sMin.pop();
    }
    
    public int top() {
        return sMain.peek();
    }
    
    public int getMin() {
       return sMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */