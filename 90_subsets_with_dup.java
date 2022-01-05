class Solution {
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, true, new LinkedList());
        return ret;
    }
    public void helper(int[] nums, int index, boolean selectLast, LinkedList<Integer> list) {
        if (index == nums.length) {
            ret.add(new LinkedList<>(list));
            return;
        }
        if (selectLast || nums[index] != nums[index - 1]) {
            list.add(nums[index]);
            helper(nums, index + 1, true, list);
            list.pollLast();
            helper(nums, index + 1, false, list);
        } else {
            helper(nums, index + 1, false, list);
        }
    }

}
