class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<String> stack = new LinkedList<>();
        int sum = 0;
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int val2 = Integer.valueOf(stack.pollLast());
                int val1 = Integer.valueOf(stack.pollLast());
                if (token.equals("+")) {
                    stack.addLast(String.valueOf(val1 + val2));
                } else if (token.equals("-")) {
                    stack.addLast(String.valueOf(val1 - val2));
                } else if (token.equals("*")) {
                     stack.addLast(String.valueOf(val1 * val2));
                } else {
                    stack.addLast(String.valueOf(val1 / val2));
                }
            } else {
                stack.addLast(token);
            }
        }
        return Integer.valueOf(stack.pollLast());
    }
}
