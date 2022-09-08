class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[2][n];
        //第一个房屋不偷窃
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = dp[0][i - 1] + nums[i];
        }
        int maxProfit1 = Math.max(dp[0][n - 1], dp[1][n - 1]);
        //第一个房屋要偷窃
        if (n >= 2) {
            dp[0][1] = 0;
            dp[1][1] = 0;
        }
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
            dp[1][i] = dp[0][i - 1] + nums[i];
        }
        int maxProfit2 = dp[0][n - 1] + nums[0];
        return Math.max(maxProfit1, maxProfit2);
    }
}
