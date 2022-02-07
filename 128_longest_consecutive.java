class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        int cur = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (set.contains(num - 1)) {
                continue;
            } else {
                do {
                    cur++;
                    max = Math.max(cur, max);
                } while (set.contains(++num));
                cur = 0;
            }
        }
        return max;
    }
}
