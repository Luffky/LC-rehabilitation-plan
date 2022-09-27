/*
 * @lc app=leetcode.cn id=268 lang=java
 *
 * [268] 丢失的数字
 */

// @lc code=start
class Solution {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val != i && val < nums.length) {
                nums[i] = -1;
                while (val < nums.length && val != -1) {
                    int temp = nums[val];
                    nums[val] = val;
                    val = temp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}
// @lc code=end

