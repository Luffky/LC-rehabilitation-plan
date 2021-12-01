class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.size() == 0) {
                    return false;
                } else if (ch == ']' && stack.pop() != '[') {
                    return false;
                } else if (ch == '}' && stack.pop() != '{') {
                    return false;
                } else if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
            } 
        }
        return stack.size() == 0;
    }
}
