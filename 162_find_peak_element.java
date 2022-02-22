class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else {
            return helper(nums, 0, nums.length - 1);
        }
    }
    public int helper(int[] nums, int start, int end) {
        int middle = start + (end - start) / 2;
        if (middle == 0 && nums[middle] > nums[middle + 1]) {
            return middle;
        } else if (middle == nums.length - 1 && nums[middle] > nums[middle - 1]) {
            return middle;
        } else if (middle != 0 && middle != nums.length - 1 && nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            return middle;
        } else {
            if (middle != 0 && nums[middle - 1] > nums[middle]) {
                return helper(nums, start, middle - 1);
            } else {
                return helper(nums, middle + 1, end);
            }
        }
    }
}
