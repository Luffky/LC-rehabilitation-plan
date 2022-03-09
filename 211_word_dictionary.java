class WordDictionary {
    class Node {
        char ch;
        Node[] children;
        boolean isWord;
        public Node(char ch) {
            this.ch = ch;
            children = new Node[26];
        }
    }
    Node root;
    
    public WordDictionary() {
        root = new Node('a');
    }
    
    public void addWord(String word) {
        insertHelper(word, root, 0);
    }
    
    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }


    private boolean searchHelper(String word, Node cur, int index) {
        if (index == word.length()) {
            return cur.isWord == true;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node child : cur.children) {
                if (child != null) {
                    boolean hasFound = searchHelper(word, child, index + 1);
                    if (hasFound) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            if (cur.children[ch - 'a'] == null) {
                return false;
            } 
            return searchHelper(word, cur.children[ch - 'a'], index + 1);
        }
    }

    private void insertHelper(String word, Node cur, int index) {
        if (index == word.length()) {
            cur.isWord = true;
            return;
        }
        char ch = word.charAt(index);
        if (cur.children[ch - 'a'] == null) {
            cur.children[ch - 'a'] = new Node(ch);
        } 
        insertHelper(word, cur.children[ch - 'a'], index + 1);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
