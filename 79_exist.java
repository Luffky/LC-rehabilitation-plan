class Solution {
    public boolean exist(char[][] board, String word) {
        Set<String> set = new HashSet<>();
        char[] w = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == w[0]) {
                    board[i][j] = '-';
                    boolean ret = helper(board, set, w, 1, i, j);
                    if (ret) {
                        return ret;
                    }
                    board[i][j] = w[0];
                }
            }
        }
        return false;
    }

    public boolean helper(char[][] board, Set<String> set, char[] word, int i, int x, int y) {
        if (i == word.length) {
            return true;
        }
        if (x != 0 && board[x - 1][y] == word[i]) {
            board[x - 1][y] = '-';
            boolean ret = helper(board, set, word, i + 1, x - 1, y);
            if (ret) {
                return ret;
            }
            board[x - 1][y] = word[i];
        }
        if (y != 0 && board[x][y - 1] == word[i]) {
            board[x][y - 1] = '-';
            boolean ret = helper(board, set, word, i + 1, x, y - 1);
            if (ret) {
                return ret;
            }
            board[x][y - 1] = word[i];
        }
        if (x != board.length - 1 && board[x + 1][y] == word[i]) {
            board[x + 1][y] = '-';
            boolean ret = helper(board, set, word, i + 1, x + 1, y);
            if (ret) {
                return ret;
            }
            board[x + 1][y] = word[i];
        }
        if (y != board[0].length - 1 && board[x][y + 1] == word[i]) {
            board[x][y + 1] = '-';
            boolean ret = helper(board, set, word, i + 1, x, y + 1);
            if (ret) {
                return ret;
            }
            board[x][y + 1] = word[i];
        }
        return false;
    }
}
