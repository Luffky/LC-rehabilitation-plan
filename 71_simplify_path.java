class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<>();
        char[] chars = path.toCharArray();
        int beginIdx = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '/' && beginIdx == -1) {
                beginIdx = i;
            } else if (beginIdx != -1 && chars[i] == '/') {
                String temp = path.substring(beginIdx, i);
                beginIdx = -1;
                if (temp.equals(".")) {
                    continue;
                } else if (temp.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else {
                    stack.addLast(temp);
                }
            }
        }

        if (beginIdx != -1) {
            String temp = path.substring(beginIdx, path.length());
                if (temp.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pollLast();
                    }
                } else if (!temp.equals(".")){
                    stack.addLast(temp);
                }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollFirst());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }
        return sb.toString();
    }
}
