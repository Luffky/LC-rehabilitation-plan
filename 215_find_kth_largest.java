class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSearch(nums, 0, nums.length - 1, nums.length - k + 1);
    }
    public int quickSearch(int[] nums, int s, int e, int k) {
        int rank = quickSearchHelper(nums, s, e);
        if (rank + 1 == k) {
            return nums[rank];
        } else if (rank + 1 > k) {
            return quickSearch(nums, s, rank - 1, k);
        } else {
            return quickSearch(nums, rank + 1, e, k);
        }
    }
    public int quickSearchHelper(int[] nums, int s, int e) {
        shuffleArray(nums, s, e);
        int pivot = nums[e];
        int idx = s - 1;
        for (int i = s; i < e; i++) {
            if (pivot > nums[i]) {
                idx++;
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
            }
        }
        nums[e] = nums[idx + 1];
        nums[idx + 1] = pivot;
        return idx + 1;
    }
    //打乱数组，随机交换最后一个元素
    public void shuffleArray(int[] nums, int s, int e) {
        int ridx = s + (int) (Math.random() * (e - s + 1));
        int tmp = nums[e];
        nums[e] = nums[ridx];
        nums[ridx] = tmp;
    }
}
