/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2 的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) {
            return false;
        }
        int zeroCnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                zeroCnt++;
            }
            n >>= 1;
        }
        return zeroCnt == 1;
    }
}
// @lc code=end

