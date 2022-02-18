class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int start, int end) {
        int middle = start + (end - start) / 2;
        if (nums[start] <= nums[end]) {
            return nums[start];
        } else {
            if (nums[middle] >= nums[start]) {
                return helper(nums, middle + 1, end);
            } else{
                return helper(nums, start, middle);
            }
        }
    }
}
