class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> twoMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i)) && !twoMap.containsKey(t.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                twoMap.put(t.charAt(i), s.charAt(i));
            } else if (!map.containsKey(s.charAt(i)) || !twoMap.containsKey(t.charAt(i))) {
                return false;
            } else if (map.get(s.charAt(i)) != t.charAt(i) || twoMap.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
