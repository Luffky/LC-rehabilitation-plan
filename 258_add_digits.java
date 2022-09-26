/*
 * @lc app=leetcode.cn id=258 lang=java
 *
 * [258] 各位相加
 */

// @lc code=start
class Solution {
    public int addDigits(int num) {
        int total = num;
        while (total > 9) {
            num = total;
            total = 0;
            while (num != 0) {
                total += num % 10;
                num /= 10;
            }
        }
        return total;
    }
}
// @lc code=end

