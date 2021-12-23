class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int m1 = 1;
        int m2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = m1;
            m1 = m2;
            m2 = temp + m2;
        }
        return m2;
    }
}
