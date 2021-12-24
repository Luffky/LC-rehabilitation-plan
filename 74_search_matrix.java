class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix, target, 0, matrix[0].length * matrix.length - 1);
    }

    public boolean helper(int[][] matrix, int target, int s, int e) {
        if (s > e) {
            return false;
        }
        int m = s + (e - s) / 2;
        int row = m / matrix[0].length;
        int column = m - matrix[0].length * row;
        if (matrix[row][column] == target) {
            return true;
        } else if (matrix[row][column] < target) {
            return helper(matrix, target, m + 1, e);
        } else {
            return helper(matrix, target, s, m - 1);
        }
    }
}
