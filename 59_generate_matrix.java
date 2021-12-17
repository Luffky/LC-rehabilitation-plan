class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int N = n;
        int x = 0;
        while (num <= N * N) {
            num = helper(matrix, n, x, num);
            n -= 2;
            x++;
        }
        return matrix;
    }

    public int helper(int[][] matrix, int n, int x, int num) {
        if (n == 1) {
            matrix[x][x] = num++;
            return num;
        }
        for (int i = x; i < x + n - 1; i++) {
            matrix[x][i] = num++;
        }
        for (int i = x; i < x + n - 1; i++) {
            matrix[i][x + n - 1] = num++;
        }
        for (int i = x + n - 1; i > x; i--) {
            matrix[x + n - 1][i] = num++;
        }
        for (int i = x + n - 1; i > x; i--) {
            matrix[i][x] = num++;
        }
        return num;
    }
}
