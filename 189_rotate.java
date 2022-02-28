class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int total = k;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < total; i++) {
            if (set.contains(i)) {
                continue;
            }
            int j = i;
            int temp = nums[j];
            do {
                int next = (j + k) % nums.length;
                int tmp2 = nums[next];
                nums[next] = temp;
                temp = tmp2;
                set.add(j);
                j = next;
            } while (j != i);
        }
    
    }
}
