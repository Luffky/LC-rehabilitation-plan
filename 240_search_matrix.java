/*
 * @lc app=leetcode.cn id=240 lang=java
 *
 * [240] 搜索二维矩阵 II
 */

// @lc code=start
class Solution {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     return helper(matrix, 0, matrix[0].length, 0, matrix.length, target);
    // }
    
    // public boolean helper(int[][] matrix, int x1, int x2, int y1, int y2, int target) {
    //     // System.out.println("" + x1 + " " + x2 + " " + y1 + " " + y2);
    //     if (x1 >= x2 || y1 >= y2) {
    //         return false;
    //     }
    //     int xm = (x1 + x2) / 2;
    //     int ym = (y1 + y2) / 2;
    //     if (matrix[ym][xm] == target) {
    //         return true;
    //     } else if (matrix[ym][xm] > target) {
    //         return helper(matrix, x1, x2, y1, ym, target) || helper(matrix, x1, xm, ym, y2, target);
    //     } else {
    //         return helper(matrix, x1, x2, ym + 1, y2, target) || helper(matrix, xm + 1, x2, y1, ym + 1, target);
    //     }
    // }

    public boolean searchMatrix(int[][] matrix, int target) {
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                y--;
            } else {
                x++;
            }
        }
        return false;
    }
}
// @lc code=end

