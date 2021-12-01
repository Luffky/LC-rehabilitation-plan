class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target < (long) nums[i] * 4 ) {
                break;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (target - nums[i] < (long) nums[j] * 3) {
                    break;
                }
                Set<Integer> set = new HashSet<>();
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
                        if (!set.contains(nums[start])) {
                            set.add(nums[start]);
                            ret.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        }
                        start++;
                    } else if (nums[i] + nums[j] + nums[start] + nums[end] > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return ret;
    }
}
