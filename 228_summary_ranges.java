/*
 * @lc app=leetcode.cn id=228 lang=java
 *
 * [228] 汇总区间
 */

// @lc code=start
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<>();
        if (nums.length == 0) {
            return ret;
        }
        int start = 0;
        int startNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (i - start == 1) {
                    ret.add(String.valueOf(startNum));
                } else {
                    ret.add(String.valueOf(startNum) + "->" + String.valueOf(nums[i - 1]));
                }
                start = i;
                startNum = nums[i];
            }
        }
        if (start == nums.length - 1) {
            ret.add(String.valueOf(startNum));
        } else {
            ret.add(String.valueOf(startNum) + "->" + String.valueOf(nums[nums.length - 1]));
        }
        return ret;
    }
}
// @lc code=end

