class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] memory = new boolean[s.length()];
        return helper(s, set, 0, memory);
    }

    public boolean helper(String s, Set<String> set, int index, boolean[] memory) {
        if (index == s.length()) {
            return true;
        }
        if (memory[index]) {
            return false;
        }
        for (int i = index; i < s.length(); i++) {
            String subString = s.substring(index, i + 1);
            if (set.contains(subString)) {
                boolean canBreak = helper(s, set, i + 1, memory);
                if (canBreak) {
                    return true;
                }
            }
        }
        memory[index] = true;
        return false;
    }
}
