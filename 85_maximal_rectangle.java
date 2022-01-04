class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] = arr[j] + 1;
                }
            }
            LinkedList<Integer> queue = new LinkedList<>();
            int[] left = new int[arr.length];
            int[] right = new int[arr.length];
            for (int j = 0; j < arr.length; j++) {
                while (!queue.isEmpty() && arr[queue.peekLast()] >= arr[j]) {
                    queue.pollLast();
                }
                left[j] = queue.isEmpty() ? -1 : queue.peekLast();
                queue.addLast(j);
            }
            queue.clear();
            for (int j = arr.length - 1; j >= 0; j--) {
                while (!queue.isEmpty() && arr[queue.peekLast()] >= arr[j]) {
                    queue.pollLast();
                }
                right[j] = queue.isEmpty() ? arr.length : queue.peekLast();
                queue.addLast(j);
            }
            queue.clear();
            for (int j = 0; j < arr.length; j++) {
                max = Math.max(max, (right[j] - left[j] - 1) * arr[j]);
            }
        }
        return max;
    }
}
