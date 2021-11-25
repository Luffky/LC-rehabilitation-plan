class Solution {
    public int reverse(int x) {
        if (x == -2147483648) {
            return 0;
        }
        boolean negative = x < 0 ? true : false;
        if (negative) {
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            if (result > 214748364) {
                return 0;
            } else if ((result == 214748364) && ((negative && digit > 8) || (!negative && digit > 7))) {
                return 0;
            }
            result = result * 10 + digit;
            x /= 10;
        }
        if (negative) {
            result = -result;
        }
        return result;
    }
}
