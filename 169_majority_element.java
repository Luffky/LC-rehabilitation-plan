class Solution {
    public int majorityElement(int[] nums) {
        int prev = -1;
        int total = 0;
        for (int num : nums) {
            if (total == 0) {
                prev = num;
                total++;
            } else if (prev == num) {
                total++;
            } else {
                total--;
            }
        }
        return prev;
    }
}
