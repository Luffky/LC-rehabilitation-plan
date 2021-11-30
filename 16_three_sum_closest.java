class Solution {
    public int threeSumClosest(int[] nums, int target) {
        quickSort(nums, 0, nums.length - 1);
        int closestSum = Integer.MAX_VALUE - 20000;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int tar = target - nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == tar) {
                    return target;
                } else if (nums[start] + nums[end] > tar) {
                    if (Math.abs(nums[start] + nums[end] - tar) < Math.abs(closestSum - target)) {
                        closestSum = nums[start] + nums[end] + nums[i];
                    }
                    end--;
                } else {
                    if (Math.abs(nums[start] + nums[end] - tar) < Math.abs(closestSum - target)) {
                        closestSum = nums[start] + nums[end] + nums[i];
                    }
                    start++;
                }
            }
        }
        return closestSum;
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
