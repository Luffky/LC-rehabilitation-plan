class Solution {
    Map<Integer, List<Character>> map = new HashMap<>();
    {
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }
    public List<String> letterCombinations(String digits) {
        char[] chars = digits.toCharArray();
        List<String> result = new LinkedList<>();
        helper(chars, result, 0, new StringBuilder());
        return result;
    }

    public void helper(char[] chars, List<String> ret, int curPos, StringBuilder sb) {
        if (curPos >= chars.length) {
            if (sb.length() > 0) {
                ret.add(sb.toString());
            }
            return;
        }
        int curChar = chars[curPos] - '0';
        for (char selectedChar : map.get(curChar)) {
            sb.append(selectedChar);
            helper(chars, ret, curPos + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
