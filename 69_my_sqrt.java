class Solution {
    public int mySqrt(int x) {
        return (int) helper(x, 1, x);
    }

    public long helper(int x, long s, long e) {
        if (s > e) {
            return e;
        }
        long m = s + (e - s) / 2;
        if (m > x / m) {
            return helper(x, s, m - 1);
        } else if (m == x / m) {
            return m;
        } else {
            return helper(x, m + 1, e);
        }
    }
}
