class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int curPos = 0;
        char curChar = ' ';
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (curPos < strs[i].length()) {
                    if (curChar == ' ') {
                        curChar = strs[i].charAt(curPos);
                    } else if (curChar != strs[i].charAt(curPos)) {
                        return sb.toString();
                    }
                } else {
                    return sb.toString();
                }
            }
            sb.append(curChar);
            curChar = ' ';
            curPos++;
        }
    }
}
