class Solution {
    List<List<String>> result = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        helper(n, 0, new int[n], new int[2 * n - 1], new int[2 * n - 1], new LinkedList<>());
        return result;
    }

    public void helper(int n, int row, int[] columnMap, int[] leftAngleMap, int[] rightAngleMap, LinkedList<Integer> list) {
        if (row == n) {
            List<String> temp = new LinkedList<>();
            for (int columnIdx : list) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    if (i == columnIdx) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columnMap[i] != 1 && leftAngleMap[n + i - row - 1] != 1 && rightAngleMap[i + row] != 1) {
                columnMap[i] = 1;
                leftAngleMap[n + i - row - 1] = 1;
                rightAngleMap[i + row] = 1;
                list.add(i);
                helper(n, row + 1, columnMap, leftAngleMap, rightAngleMap, list);
                columnMap[i] = 0;
                leftAngleMap[n + i - row - 1] = 0;
                rightAngleMap[i + row] = 0;
                list.pollLast();
            }
        }
    }
}
