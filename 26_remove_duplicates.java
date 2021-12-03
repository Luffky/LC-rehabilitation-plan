class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = -20000;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[index++] = nums[i];
                prev = nums[i];
            }
        }
        return index;
    }
}
