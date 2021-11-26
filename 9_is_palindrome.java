class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x > 2147447412) {
            return false;
        }
        int result = 0;
        int temp = x;
        while (temp > 0) {
            int digit = temp % 10;
            if (result > Integer.MAX_VALUE) {
                return false;
            } else if (result == Integer.MAX_VALUE && digit > 7) {
                return false;
            }
            result = result * 10 + digit;
            temp /= 10;
        }
        return x == result;
    }
}
