class Solution {
    public int largestRectangleArea(int[] heights) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] left = new int[heights.length];
        int [] right = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!queue.isEmpty() && heights[queue.peekLast()] >= heights[i]) {
                queue.pollLast();
            }
            left[i] = queue.isEmpty() ? -1 : queue.peekLast();
            queue.addLast(i);
        }

        queue = new LinkedList<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && heights[queue.peekLast()] >= heights[i]) {
                queue.pollLast();
            }
            right[i] = queue.isEmpty() ? heights.length : queue.peekLast();
            queue.addLast(i);
        }

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
    }
}
