class Solution {
    List<List<String>> ret = new LinkedList<>();
    public List<List<String>> partition(String s) {
        boolean[][] g = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                if (i == 0) {
                    g[j][j] = true;
                } else if (i == 1 && s.charAt(j) == s.charAt(j + 1)) {
                    g[j][j + 1] = true;
                } else if (i > 1) {
                    g[j][j + i] = g[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i);
                }
            }
        }

        helper(s, 0, new LinkedList<>(), g);
        return ret;
    }
    public void helper(String s, int index, LinkedList<String> list, boolean[][] g) {
        if (index == s.length()) {
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (g[index][i]) {
                list.addLast(s.substring(index, i + 1));
                helper(s, i + 1, list, g);
                list.pollLast();
            } 
        }
    }

}
