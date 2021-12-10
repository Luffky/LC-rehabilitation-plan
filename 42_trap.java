class Solution {
    public int trap(int[] height) {
        LinkedList<Integer> stack = new LinkedList<>();
        int ret = 0;
        for (int i = 0; i < height.length; i++) {
            while (stack.size() != 0 && height[stack.peekLast()] < height[i]) {
                int idx = stack.pollLast();
                if (stack.size() != 0) {
                    ret += (i - stack.peekLast() - 1) * (Math.min(height[i], height[stack.peekLast()]) - height[idx]);
                }
            }
            stack.add(i);
        }
        return ret;
    }
}
