class Solution {
    class Node {
        String word;
        List<Node> prev;
        public Node(String word) {
            this.word = word;
            prev = new LinkedList<>();
        }
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<Node> nodeList = new LinkedList<>();
        Node beginNode = new Node(beginWord);
        Node endNode = null;
        List<List<String>> ret = new LinkedList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                endNode = new Node(wordList.get(i));
                nodeList.add(endNode);
            } else {
                nodeList.add(new Node(wordList.get(i)));
            }
        }
        if (endNode == null) {
            return ret;
        }
        Map<Node, List<Node>> map = new HashMap<>();
        for (int i = 0; i < nodeList.size(); i++) {
            if (diffOneWord(nodeList.get(i).word, beginNode.word)) {
                if (!map.containsKey(nodeList.get(i))) {
                    map.put(nodeList.get(i), new LinkedList<Node>());
                }
                if (!map.containsKey(beginNode)) {
                    map.put(beginNode, new LinkedList<Node>());
                }
                map.get(nodeList.get(i)).add(beginNode);
                map.get(beginNode).add(nodeList.get(i));
            }
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (diffOneWord(nodeList.get(i).word, nodeList.get(j).word)) {
                    if (!map.containsKey(nodeList.get(i))) {
                        map.put(nodeList.get(i), new LinkedList<Node>());
                    }
                    if (!map.containsKey(nodeList.get(j))) {
                        map.put(nodeList.get(j), new LinkedList<>());
                    }
                    map.get(nodeList.get(i)).add(nodeList.get(j));
                    map.get(nodeList.get(j)).add(nodeList.get(i));
                }
            }
        }

        // for (Node node : nodeList) {
        //     List<Node> list = map.get(node);
        //     System.out.println("from: " + node.word);
        //     for (Node next : list) {
        //         System.out.print(next.word + ", ");
        //     }
        //     System.out.println();
        // }
        LinkedList<Node> queue = new LinkedList<>();
        LinkedList<Node> queue2 = new LinkedList<>();
        Map<Node, Integer> map2 = new HashMap<>();
        queue2.addLast(beginNode);
        int dist = 0;
        map2.put(beginNode, dist);
        while (!queue.isEmpty() || !queue2.isEmpty()) {
            queue = queue2;
            queue2 = new LinkedList<>();
            dist++;
            while (!queue.isEmpty()) {
                Node cur = queue.pollFirst();
                if (cur == endNode) {
                    break;
                }
                if (!map.containsKey(cur)) {
                    continue;
                }
                for (Node next : map.get(cur)) {
                    if (!map2.containsKey(next)) {
                        queue2.addLast(next);
                        map2.put(next, dist);
                    }
                    if (map2.get(next) == dist) {
                        next.prev.add(cur);
                    }
                }
            }
        }
        // for (Node node : nodeList) {
        //     printNode(node);
        // }
        dfs(endNode, ret, new LinkedList<>(), beginNode);
        return ret;
    }

    public void dfs(Node cur, List<List<String>> ret, LinkedList<String> list, Node beginNode) {
        if (cur == beginNode) {
            list.addFirst(cur.word);
            ret.add(new LinkedList<>(list));
            list.pollFirst();
            return;
        }
        list.addFirst(cur.word);
        for (Node next : cur.prev) {
            dfs(next, ret, list, beginNode);
        }
        list.pollFirst();
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

    public void printNode(Node node) {
        System.out.print("node: " + node.word + ", prev: ");
        for (Node next : node.prev) {
            System.out.print(next.word + ", ");
        }
        System.out.println();
    }
}
