class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[dungeon.length - 1][dungeon[0].length - 1] = getLowestLife(1 - dungeon[dungeon.length - 1][dungeon[0].length - 1]);
        for (int i = dungeon.length - 2; i >= 0; i--) {
            dp[i][dungeon[0].length - 1] = getLowestLife(dp[i + 1][dungeon[0].length - 1] - dungeon[i][dungeon[0].length - 1]);
        }
        for (int i = dungeon[0].length - 2; i >= 0; i--) {
            dp[dungeon.length - 1][i] = getLowestLife(dp[dungeon.length - 1][i + 1] - dungeon[dungeon.length - 1][i]);
        }

        int k = dungeon[0].length - 2;
        int l = dungeon.length - 2;
        while (k >= 0 && l >= 0) {
            for (int i = k; i >= 0; i--) {
                dp[l][i] = getLowestLife(Math.min(dp[l + 1][i], dp[l][i + 1]) - dungeon[l][i]);
            }
            for (int i = l - 1; i >= 0; i--) {
                dp[i][k] = getLowestLife(Math.min(dp[i + 1][k], dp[i][k + 1]) - dungeon[i][k]);
            }
            k--;
            l--;
        }
        return dp[0][0];
    }

    public int getLowestLife(int val) {
        if (val <= 0) {
            return 1;
        } else {
            return val;
        }
    }
}
