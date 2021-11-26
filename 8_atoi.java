class Solution {
    public int myAtoi(String s) {
        char[] chs = s.toCharArray();
        int result = 0;
        boolean hasBegun = false;
        boolean negative = false;
        for (char ch : chs) {
            if (ch == ' ') {
                if (hasBegun) {
                    break;
                }
            } else if (ch >= '0' && ch <= '9') {
                hasBegun = true;
                if (result > Integer.MAX_VALUE / 10) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else if (result == Integer.MAX_VALUE / 10) {
                    if (negative && ch > '8') {
                        return Integer.MIN_VALUE;
                    } else if (!negative && ch > '7') {
                        return Integer.MAX_VALUE;
                    } else {
                        result = result * 10 + (ch - '0');
                    }
                } else {
                    result = result * 10 + (ch - '0');
                }
            } else if (ch == '-' || ch == '+') {
                if (hasBegun) {
                    break;
                } else {
                    hasBegun = true;
                    negative = ch == '-'? true : false;
                }
            } else {
                break;
            }
        }
        return negative ? -result : result;
    }
}
