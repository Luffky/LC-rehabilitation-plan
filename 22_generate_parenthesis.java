class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<>();
        helper(n, 0, new StringBuilder(), ret);
        return ret;
    }

    public void helper(int n, int m, StringBuilder curStr, List<String> ret) {
        if (n == 0 && m == 0) {
            ret.add(curStr.toString());
            return;
        }
        if (n > 0) {
            curStr.append('(');
            helper(n - 1, m + 1, curStr, ret);
            curStr.deleteCharAt(curStr.length() - 1);
        }
        if (m > 0) {
            curStr.append(')');
            helper(n, m - 1, curStr, ret);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
