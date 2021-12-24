class Solution {
    public void sortColors(int[] nums) {
        int count1 = 0, count2 = 0, count3 = 0;
        for (int num : nums) {
            if (num == 0) {
                count1++;
            } else if (num == 1) {
                count2++;
            } else {
                count3++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (count1 > 0) {
                nums[i] = 0;
                count1--;
            } else if (count2 > 0) {
                nums[i] = 1;
                count2--;
            } else {
                nums[i] = 2;
                count3--;
            }
        }
    }
}
