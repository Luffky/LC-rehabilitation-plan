/*
 * @lc app=leetcode.cn id=225 lang=java
 *
 * [225] 用队列实现栈
 */

// @lc code=start
class MyStack {
    List<Integer> list1;
    List<Integer> list2;
    boolean flag;
    public MyStack() {
        list1 = new LinkedList<>();
        list2 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!flag) {
            list1.add(x);
        } else {
            list2.add(x);
        }
    }
    
    public int pop() {
        List<Integer> tmpList = list1;
        List<Integer> tmpList2 = list2;
        if (flag) {
            tmpList = list2;
            tmpList2 = list1;
        } 
        while (true) {
            int ele = tmpList.remove(0);
            if (tmpList.isEmpty()) {
                flag = !flag;
                return ele;
            } else {
                tmpList2.add(ele);
            }
        }
    }
    
    public int top() {
        List<Integer> tmpList = list1;
        List<Integer> tmpList2 = list2;
        if (flag) {
            tmpList = list2;
            tmpList2 = list1;
        } 
        while (true) {
            int ele = tmpList.remove(0);
            tmpList2.add(ele);
            if (tmpList.isEmpty()) {
                flag = !flag;
                return ele;
            }
        }
    }
    
    public boolean empty() {
        if (flag) {
            return list2.isEmpty();
        } else {
            return list1.isEmpty();
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end

