class Solution {
    public String minWindow(String s, String t) {
        LinkedList<Integer> queue = new LinkedList<>();
        int from = -1;
        int to = -1;
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int num = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : cht) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
                num++;
            }
            map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                map.put(chs[i], map.get(chs[i]) - 1);
                queue.addLast(i);
                if (map.get(chs[i]) == 0) {
                    num--;
                }
                char ch = chs[queue.peekFirst()];
                int n = map.get(ch);
                while (n < 0) {
                    map.put(ch, n + 1);
                    queue.pollFirst();
                    ch = chs[queue.peekFirst()];
                    n = map.get(ch);
                }
                if (num == 0) {
                    if (from == -1 || (to - from) > (i - queue.peekFirst())) {
                        from = queue.peekFirst();
                        to = i;
                    }
                }
            } 
        }
        if (from == -1) {
            return "";
        }
        return s.substring(from, to + 1);
    }
}
