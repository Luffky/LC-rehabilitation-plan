class Solution {
    class Node {
        char val;
        boolean isWord;
        Map<Character, Node> children;
        public Node(char val) {
            this.val = val;
            this.children = new HashMap<Character, Node>();
        }
        public void insert(char ch) {
            if (!this.children.containsKey(ch)) {
                this.children.put(ch, new Node(ch));
            }
        }
        public void insertWord(String word) {
            this.insertWordHelper(word, 0);
        }
        public void insertWordHelper(String word, int index) {
            if (index == word.length()) {
                this.isWord = true;
                return;
            } else {
                this.insert(word.charAt(index));
                this.children.get(word.charAt(index)).insertWordHelper(word, index + 1);
            }
        }
        public void removeWord(String word) {
            this.removeWordHelper(word, 0);
        }
        public boolean removeWordHelper(String word, int index) {
            if (index == word.length()) {
                this.isWord = false;
                if (this.children.size() == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                boolean needRemove = this.children.get(word.charAt(index)).removeWordHelper(word, index + 1);
                if (needRemove) {
                    this.children.remove(word.charAt(index));
                }
                if (this.children.size() == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }
    List<String> result;
    Node root;
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0) {
            return new LinkedList<>();
        }
        root = new Node('0');
        result = new LinkedList<>();
        //构建字典树
        for (String word : words) {
            root.insertWord(word);
        }
        //遍历DFS
        int X = board.length;
        int Y = board[0].length;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (root.children.containsKey(board[i][j])) {
                    goNext(board, i, j, root, new StringBuilder());
                }
            }
        }
        return result;
    }
    public void findWordsHelper(char[][] board, int x, int y, Node cur, StringBuilder sb) {
        if (cur.isWord) {
            String word = sb.toString();
            result.add(word);
            root.removeWord(word);
        }
        if (x > 0 && cur.children.containsKey(board[x - 1][y])) {
            goNext(board, x - 1, y, cur, sb);
        }
        if (x < board.length - 1 && cur.children.containsKey(board[x + 1][y])) {
            goNext(board, x + 1, y, cur, sb);
        }
        if (y > 0 && cur.children.containsKey(board[x][y - 1])) {
            goNext(board, x, y - 1, cur, sb);
        }
        if (y < board[0].length - 1 && cur.children.containsKey(board[x][y + 1])) {
            goNext(board, x, y + 1, cur, sb);
        }
        return;
    }

    public void goNext(char[][] board, int x, int y, Node cur, StringBuilder sb) {
        char temp = board[x][y];
        Node child = cur.children.get(temp);
        sb.append(temp);
        board[x][y] = '#';
        findWordsHelper(board, x, y, child, sb);
        sb.delete(sb.length() - 1, sb.length());
        board[x][y] = temp;
    }
}
