class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int j = i;
            int temp = nums[j];
            do {
                int next = (j + k) % nums.length;
                int tmp2 = nums[next];
                nums[next] = temp;
                temp = tmp2;
                count++;
                j = next;
            } while (j != i);
        }

    }
}
