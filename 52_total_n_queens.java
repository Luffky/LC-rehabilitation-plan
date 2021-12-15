class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        helper(n, 0, new int[n], new int[2 * n - 1], new int[2 * n - 1]);
        return count;
    }

    public void helper(int n, int row, int[] columnMap, int[] leftAngleMap, int[] rightAngleMap) {
        if (row == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columnMap[i] != 1 && leftAngleMap[n + i - row - 1] != 1 && rightAngleMap[i + row] != 1) {
                columnMap[i] = 1;
                leftAngleMap[n + i - row - 1] = 1;
                rightAngleMap[i + row] = 1;
                helper(n, row + 1, columnMap, leftAngleMap, rightAngleMap);
                columnMap[i] = 0;
                leftAngleMap[n + i - row - 1] = 0;
                rightAngleMap[i + row] = 0;
            }
        }
    }
}
