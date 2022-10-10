/*
 * @lc app=leetcode.cn id=299 lang=java
 *
 * [299] 猜数字游戏
 */

// @lc code=start
class Solution {
    public String getHint(String secret, String guess) {
        int[][] arr = new int[2][10];
        int a = 0;
        int b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                arr[0][secret.charAt(i) - '0']++;
                arr[1][guess.charAt(i) - '0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(arr[0][i], arr[1][i]);
        }
        return a + "A" + b + "B";
    }
}
// @lc code=end

