class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        helper(nums, 0, ret);
        return ret;
    }

    public void helper(int[] nums, int i, List<List<Integer>> list) {
        if (i == nums.length - 1) {
            List<Integer> tmpList = new LinkedList<>();
            for (int num : nums) {
                tmpList.add(num);
            }
            list.add(tmpList);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int j = i; j < nums.length; j++) {
            if (!set.contains(nums[j])) {
                swap(nums, i, j);
                helper(nums, i + 1, list);
                swap(nums, i, j);
                set.add(nums[j]);
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
