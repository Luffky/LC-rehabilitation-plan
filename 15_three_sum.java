class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            if (target < nums[i + 1]) {
                break;
            }
            int start = i + 1;
            int end = nums.length - 1;
            Set<Integer> set = new HashSet<>();
            while (start < end) {
                if (nums[start] + nums[end] == target) {
                    if (!set.contains(nums[start])) {
                        List<Integer> tempList = Arrays.asList(nums[i], nums[start], nums[end]);
                        ret.add(tempList);
                        set.add(nums[start]);
                    }
                    start++;
                } else if (nums[start] + nums[end] > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return ret;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = quickSortHelper(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    public int quickSortHelper(int[] nums, int start, int end) {
        int pivot = nums[end];
        int cur = start - 1;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[cur + 1];
                nums[cur + 1] = nums[i];
                nums[i] = temp;
                cur++;
            }
        }
        nums[end] = nums[cur + 1];
        nums[cur + 1] = pivot;
        return cur + 1;
    }
}
