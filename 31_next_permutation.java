class Solution {
    public void nextPermutation(int[] nums) {
        int lastAscIdx = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                lastAscIdx = i - 1;
            }
        }
        if (lastAscIdx == -1) {
            swapAll(nums, 0, nums.length - 1);
        } else {
            swapAll(nums, lastAscIdx + 1, nums.length - 1);
            for (int i = lastAscIdx + 1; i < nums.length; i++) {
                if (nums[i] > nums[lastAscIdx]) {
                    int temp = nums[i];
                    nums[i] = nums[lastAscIdx];
                    nums[lastAscIdx] = temp;
                    break;
                }
            }   
        }
    }
    
    public void swapAll(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
