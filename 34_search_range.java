class Solution {
    int start = -1;
    int end = -1;
    public int[] searchRange(int[] nums, int target) {
        binarySaerch(nums, 0, nums.length - 1, 0, target);
        return new int[]{start, end};
    }

    public void binarySaerch(int[] nums, int s, int e, int flag, int target) {
        if (s > e) {
            return;
        }
        int mid = s + (e - s) / 2;
        if (nums[mid] == target) {
            if (flag == 0) {
                start = mid;
                end = mid;
                binarySaerch(nums, s, mid - 1, 1, target);
                binarySaerch(nums, mid + 1, e, 2, target);
            } else if (flag == 1) {
                start = mid;
                binarySaerch(nums, s, mid - 1, flag, target);
            } else {
                end = mid;
                binarySaerch(nums, mid + 1, e, flag, target);
            }
        } else if (nums[mid] < target) {
            binarySaerch(nums, mid + 1, e, flag, target);
        } else {
            binarySaerch(nums, s, mid - 1, flag, target);
        }
    }
}
