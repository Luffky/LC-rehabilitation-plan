/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCnt = 0;
                if (i > 0) {
                    if (board[i - 1][j] == 3 || board[i - 1][j] == 5) {
                        liveCnt++;
                    }
                    if (j > 0 && (board[i - 1][j - 1] == 3 || board[i - 1][j - 1] == 5)) {
                        liveCnt++;
                    }
                    if (j < board[0].length - 1 && (board[i - 1][j + 1] == 3 || board[i - 1][j + 1] == 5)) {
                        liveCnt++;
                    }
                }
                if (i < board.length - 1) {
                    if (board[i + 1][j] == 1) {
                        liveCnt++;
                    }
                    if (j > 0 && board[i + 1][j - 1] == 1) {
                        liveCnt++;
                    }
                    if (j < board[0].length - 1 && board[i + 1][j + 1] == 1) {
                        liveCnt++;
                    }
                }
                if (j > 0 && (board[i][j - 1] == 3 || board[i][j - 1] == 5)) {
                    liveCnt++;
                }
                if (j < board[0].length - 1 && board[i][j + 1] == 1) {
                    liveCnt++;
                }
                if (board[i][j] == 0) {
                    if (liveCnt == 3) {
                        board[i][j] = 4;
                    } else {
                        board[i][j] = 2;
                    }
                } else {
                    if (liveCnt == 2 || liveCnt == 3) {
                        board[i][j] = 5;
                    } else {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] <= 3) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }
}
// @lc code=end

