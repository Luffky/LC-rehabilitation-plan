/*
 * @lc app=leetcode.cn id=304 lang=java
 *
 * [304] 二维区域和检索 - 矩阵不可变
 */

// @lc code=start
class NumMatrix {
    int[][] ma;
    public NumMatrix(int[][] matrix) {
        ma = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    ma[i][j] = matrix[i][j];
                } else if (j == 0) {
                    ma[i][j] = ma[i - 1][j] + matrix[i][j];
                } else if (i == 0) {
                    ma[i][j] = ma[i][j - 1] + matrix[i][j];
                } else {
                    ma[i][j] = ma[i][j - 1] + ma[i - 1][j] + matrix[i][j] - ma[i - 1][j - 1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
            return ma[row2][col2];
        } else if (row1 == 0) {
            return ma[row2][col2] - ma[row2][col1 - 1];
        } else if (col1 == 0) {
            return ma[row2][col2] - ma[row1 - 1][col2];
        } else {
            return ma[row2][col2] - ma[row2][col1 - 1] - ma[row1 - 1][col2] + ma[row1 - 1][col1 - 1];
        }
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
// @lc code=end

