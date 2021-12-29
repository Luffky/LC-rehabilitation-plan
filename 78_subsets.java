class Solution {
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new LinkedList<>());
        return ret;
    }
    public void helper(int[] nums, int i, LinkedList<Integer> list) {
        if (i == nums.length) {
            ret.add(new LinkedList<>(list));
            return;
        }
        helper(nums, i + 1, list);
        list.addLast(nums[i]);
        helper(nums, i + 1, list);
        list.pollLast();
    }
}
