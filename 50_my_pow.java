class Solution {
    public double myPow(double x, int n) {
        double result = 0.0;
        boolean negative = n >= 0 ? false : true;
        result = quickPow(x, Math.abs((long) n));
        if (negative) {
            result = 1 / result;
        }
        return result;
    }

    public double quickPow(double x, long n) {
        double result = 1.0;
        while (n != 0) {
            if ((n & 1) == 1) {
                result *= x;
            }
            n >>= 1;
            x *= x;
        }
        return result;
    }
}
