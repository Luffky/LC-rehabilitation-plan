class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (pre < 0) {
                pre = nums[i];
            } else {
                pre = pre + nums[i];
            }
            max = Math.max(max, pre);
        }
        return max;
    }
}
