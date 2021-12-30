class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }

    public boolean helper(int[] nums, int target, int s, int e) {
        if (s > e) {
            return false;
        }
        int m = s + (e - s) / 2;
        if (nums[m] == target) {
            return true;
        } else if (nums[m] < target) {
            if (nums[e] == target) {
                return true;
            } else if (target < nums[e]) {
                return helper(nums, target, m + 1, e);
            } else {
                return helper(nums, target, s, m - 1) || helper(nums, target, m + 1, e);
            }
        } else {
            if (nums[e] == target) {
                return true;
            } else if (target > nums[e]) {
                return helper(nums, target, s, m - 1);
            } else {
                return helper(nums, target, s, m - 1) || helper(nums, target, m + 1, e);
            }
        }
    }
}
