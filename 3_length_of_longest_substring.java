class Solution {
    public int lengthOfLongestSubstring(String s) {
        int last = -1;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                max = Math.max(max, Math.min(i - last, i - map.get(cur)));
                last = Math.max(last, map.get(cur));
            } else {
                max = Math.max(max, i - last);
            }
            map.put(cur, i);
            if (s.length() - 1 - last <= max) {
                return max;
            }
        }
        return max;
    }
}
