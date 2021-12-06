class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (words.length == 0) {
            return new LinkedList();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 0);
            }
            map.put(words[i], map.get(words[i]) + 1);
        }
        List<Integer> ret = new LinkedList<>();
        int wn = words[0].length();
        for (int i = 0; i < wn; i++) {
            int start = i;
            int end = i;
            while (end <= s.length() - wn) {
                String subStr1 = s.substring(end, end + wn);
                if (map.containsKey(subStr1) && map.get(subStr1) != 0) {
                    map.put(subStr1, map.get(subStr1) - 1);
                    end += wn;
                } else if (end > start) {
                    String subStr2 = s.substring(start, start + wn);
                    map.put(subStr2, map.get(subStr2) + 1);
                    start += wn;
                } else {
                    start += wn;
                    end = start;
                }
                if (end - start == wn * words.length) {
                    String subStr2 = s.substring(start, start + wn);
                    ret.add(start);
                    map.put(subStr2, map.get(subStr2) + 1);
                    start += wn;
                }
            }
            while (start < end) {
                map.put(s.substring(start, start + wn), map.get(s.substring(start, start + wn)) + 1);
                start += wn;
            }
        }
        return ret;
    }
}
