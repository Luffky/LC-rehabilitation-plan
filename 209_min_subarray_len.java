class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(i - start + 1, min);
                sum -= nums[start];
                start++;
            } 
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }
}
