class Solution {
    List<Integer> list = new LinkedList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int x1 = 0, x2 = matrix.length - 1, y1 = 0, y2 = matrix[0].length - 1;
        while (x1 <= x2 && y1 <= y2) {
            helper(matrix, x1++, x2--, y1++, y2--);
        }
        return list;
    }

    public void helper(int[][] matrix, int x1, int x2, int y1, int y2) {
        //特殊处理只有一行一列的情况
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) {
                list.add(matrix[x1][i]);
            }
            return;
        } else if (y1 == y2) {
            for (int i = x1; i <= x2; i++) {
                list.add(matrix[i][y1]);
            }
            return;
        }
        for (int i = y1; i < y2; i++) {
            list.add(matrix[x1][i]);
        }
        for (int i = x1; i < x2; i++) {
            list.add(matrix[i][y2]);
        }
        for (int i = y2; i > y1; i--) {
            list.add(matrix[x2][i]);
        }
        for (int i = x2; i > x1; i--) {
            list.add(matrix[i][y1]);
        }
    }
}
