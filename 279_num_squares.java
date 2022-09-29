import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int k = 1;
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (k * k == i) {
                dp[i] = 1;
                list.add(i);
                k++;
            } else {
                int min = Integer.MAX_VALUE;
                for (int l : list) {
                    min = Math.min(min, dp[i - l] + 1);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}
// @lc code=end

