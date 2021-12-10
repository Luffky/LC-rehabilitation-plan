class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            swap(nums, nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public void swap(int[] nums, int target) {
        if (target > nums.length || target <= 0) {
            return;
        } else if (nums[target - 1] == target) {
            return;
        } else {
            int temp = nums[target - 1];
            nums[target - 1] = target;
            swap(nums, temp);
        }
    }
}
