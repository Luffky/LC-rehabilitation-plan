class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min = 0;
        int max = 0;
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num == 0) {
                min = 0;
                max = 0;
            } else if (num > 0) {
                if (max == 0) {
                    max = 1;
                }
                int tempMax = max;
                int tempMin = min;
                min = tempMin * num;
                max = tempMax * num;
            } else {
                if (max == 0) {
                    max = 1; 
                }
                int tempMax = max;
                int tempMin = min;
                min = tempMax * num;
                max = tempMin * num;
            }
            m = Math.max(m, max);
        }
        return m;
    }
}
