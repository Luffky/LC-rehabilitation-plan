class Solution {
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cnt++;
            } else {
                nums[i - cnt] = nums[i];
                if (i - cnt != i) {
                    nums[i] = 0;
                }
            }
        }
    }
}
