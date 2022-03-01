class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Math.min(k, i + 1); j++) {
                if (i == 0) {
                    dp[i][j][0] = -prices[i];
                } else {
                    if (j == 0) {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], -prices[i]);
                    } else if (j == i) {
                        dp[i][j][0] = dp[i][j - 1][1] - prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][1] - prices[i]);
                    }
                    if (j < i) {
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + prices[i]);
                        max = Math.max(max, dp[i][j][1]);
                    }                     
                }
            }
        }
        return max;
    }
}
