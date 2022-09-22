/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int mul = 1;
        for (int i = 0; i < nums.length; i++) {
            mul *= nums[i];
            ret[i] = mul;
        }
        mul = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            mul *= nums[i];
            nums[i] = mul;
        }
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp2 = ret[i];
            if (i == 0) {
                ret[i] = nums[i + 1];
            } else if (i == nums.length - 1) {
                ret[i] = tmp;
            } else {
                ret[i] = tmp * nums[i + 1];
            }
            tmp = tmp2;
        }
        return ret;
    }
}
// @lc code=end

