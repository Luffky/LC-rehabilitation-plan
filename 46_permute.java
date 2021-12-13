class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        helper(nums, 0, list);
        return list;
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
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            helper(nums, i + 1, list);
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
