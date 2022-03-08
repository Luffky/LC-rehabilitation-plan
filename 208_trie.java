class Trie {
    class Node {
        char ch;
        Map<Character, Node> children;
        boolean isWord;
        public Node(char ch) {
            this.ch = ch;
            children = new HashMap<>();
        }
    }
    Node root;
    public Trie() {
        root = new Node('a');
    }
    
    public void insert(String word) {
        insertHelper(word, root, 0);
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0, false);
    }
    
    public boolean startsWith(String prefix) {
        return searchHelper(prefix, root, 0, true);
    }

    private boolean searchHelper(String word, Node cur, int index, boolean isPrefix) {
        if (index == word.length()) {
            if (isPrefix) {
                return true;
            } else {
                return cur.isWord == true;
            }
        }
        char ch = word.charAt(index);
        if (!cur.children.containsKey(ch)) {
            return false;
        } 
        return searchHelper(word, cur.children.get(ch), index + 1, isPrefix);
    }

    private void insertHelper(String word, Node cur, int index) {
        if (index == word.length()) {
            cur.isWord = true;
            return;
        }
        char ch = word.charAt(index);
        if (!cur.children.containsKey(ch)) {
            cur.children.put(ch, new Node(ch)); 
        } 
        insertHelper(word, cur.children.get(ch), index + 1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
