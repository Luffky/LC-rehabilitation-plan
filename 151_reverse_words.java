class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<String> stack = new LinkedList<>();
        for (int i = 0; i < s.length();i++) {
            if (s.charAt(i) != ' ') {
                StringBuilder temp = new StringBuilder();
                while (i < s.length() && s.charAt(i) != ' ') {
                    temp.append(s.charAt(i++));
                }
                stack.addLast(temp.toString());
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
            if (!stack.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
