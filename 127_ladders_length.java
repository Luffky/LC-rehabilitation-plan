class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ret = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (diffOneWord(wordList.get(i), beginWord)) {
                if (!map.containsKey(wordList.get(i))) {
                    map.put(wordList.get(i), new LinkedList<String>());
                }
                if (!map.containsKey(beginWord)) {
                    map.put(beginWord, new LinkedList<String>());
                }
                map.get(wordList.get(i)).add(beginWord);
                map.get(beginWord).add(wordList.get(i));
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (diffOneWord(wordList.get(i), wordList.get(j))) {
                    if (!map.containsKey(wordList.get(i))) {
                        map.put(wordList.get(i), new LinkedList<String>());
                    }
                    if (!map.containsKey(wordList.get(j))) {
                        map.put(wordList.get(j), new LinkedList<>());
                    }
                    map.get(wordList.get(i)).add(wordList.get(j));
                    map.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        LinkedList<String> queue = new LinkedList<>();
        LinkedList<String> queue2 = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add(beginWord);
        queue2.addLast(beginWord);
        int dist = 0;
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            queue = queue2;
            queue2 = new LinkedList<>();
            dist++;
            while (!queue.isEmpty()) {
                String cur = queue.pollFirst();
                if (cur.equals(endWord)) {
                    return dist;
                }
                if (!map.containsKey(cur)) {
                    continue;
                }
                for (String next : map.get(cur)) {
                    if (set.contains(next)) {
                        continue;
                    }
                    queue2.addLast(next);
                    set.add(next);

                }
            }
        }
        return 0;
    }

    public boolean diffOneWord(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int count = 0;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}
