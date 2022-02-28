class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String subStr = s.substring(i, i + 10);
            if (set.contains(subStr)) {
                set2.add(subStr);
            } else {
                set.add(subStr);
            }
        }
        return new LinkedList<>(set2);
    }
}
