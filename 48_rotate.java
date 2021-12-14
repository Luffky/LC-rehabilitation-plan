class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int i = 0;
        while (n > 0) {
            rotateHelper(matrix, n, i);
            n -= 2;
            i++;
        }
    }

    public void rotateHelper(int[][] matrix, int n, int start) {
        for (int i = start; i - start < n - 1; i++) {
            int temp = matrix[start][i];
            matrix[start][i] = matrix[start + n - 1 - (i - start)][start];
            matrix[start + n - 1 - (i - start)][start] = matrix[start + n - 1][start + n - 1 - (i - start)];
            matrix[start + n - 1][start + n - 1 - (i - start)] = matrix[i][start + n - 1];
            matrix[i][start + n - 1] = temp;
        }
    }
}
