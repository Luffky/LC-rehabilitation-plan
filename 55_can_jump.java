class Solution {
    public boolean canJump(int[] nums) {
        int curMax = 0;
        int i = 0;
        while (i <= curMax && i < nums.length) {
            curMax = Math.max(curMax, nums[i] + i);
            i++;
        }
        return i == nums.length;
    }
}
