import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=232 lang=java
 *
 * [232] 用栈实现队列
 */

// @lc code=start
class MyQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }
    
    public void push(int x) {
        stack2.addLast(x);
    }
    
    public int pop() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.addLast(stack2.removeLast());
            }
        }
        return stack1.removeLast();
    }
    
    public int peek() {
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.addLast(stack2.removeLast());
            }
        }
        return stack1.peekLast();
    }
    
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

