class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sortStr = String.valueOf(ch);
            if (!map.containsKey(sortStr)) {
                map.put(sortStr, new LinkedList<>());
            }
            map.get(sortStr).add(str);
        }
        return new LinkedList<>(map.values());
    }
}
