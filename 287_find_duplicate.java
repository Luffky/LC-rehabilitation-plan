/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int temp = nums[i];
                nums[i] = -1;
                while(temp != -1 && nums[temp - 1] != temp) {
                    int tmp = nums[temp - 1];
                    nums[temp - 1] = temp;
                    temp = tmp;
                }
                if (temp != -1) {
                    return temp;
                }
            }
        }
        return -1;
    }
}
// @lc code=end

