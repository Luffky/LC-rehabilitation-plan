class MinStack {
    LinkedList<Integer> stack;
    LinkedList<Integer> minStack;
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (minStack.isEmpty() || minStack.peekLast() >= val) {
            minStack.addLast(val);
        }
    }
    
    public void pop() {
        int val = stack.pollLast();
        if (minStack.peekLast() == val) {
            minStack.pollLast();
        }
    }
    
    public int top() {
        return stack.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
