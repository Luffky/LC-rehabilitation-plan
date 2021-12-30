class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = -1;
        int index = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prev == -1 || nums[prev] != nums[i]) {
                nums[index++] = nums[i];
                prev = index - 1;
                num = 1;
            } else if (num < 2) {
                num++;
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
