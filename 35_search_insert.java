class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    public int binarySearch(int[] nums, int target, int s, int e) {
        if (s > e) {
            return s;
        }
        int m = s + (e - s) / 2;
        if (nums[m] == target) {
            return m;
        } else if (nums[m] < target) {
            return binarySearch(nums, target, m + 1, e);
        } else {
            return binarySearch(nums, target, s, m - 1);
        }
    }
}
