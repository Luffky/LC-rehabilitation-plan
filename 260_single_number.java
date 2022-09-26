/*
 * @lc app=leetcode.cn id=260 lang=java
 *
 * [260] 只出现一次的数字 III
 */

// @lc code=start
class Solution {
    public int[] singleNumber(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        int mod = 1;
        while ((tmp & mod) == 0) {
            mod *= 2;
        }

        int[] ret = new int[2];
        tmp = 0;
        int tmp2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mod) == 0) {
                tmp ^= nums[i];
            } else {
                tmp2 ^= nums[i];
            }
        }
        ret[0] = tmp;
        ret[1] = tmp2;
        return ret;
    }
}
// @lc code=end

