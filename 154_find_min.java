class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int middle = start + (end - start) / 2;
        if (start == end) {
            return nums[start];
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            if (middle == start) {
                return nums[end];
            }
            if (nums[middle] > nums[start]) {
                return helper(nums, middle + 1, end);
            } else if (nums[middle] < nums[start]) {
                return helper(nums, start, middle);
            } else {
                return Math.min(helper(nums, middle + 1, end), helper(nums, start, middle - 1));
            }
        }
    }
}
