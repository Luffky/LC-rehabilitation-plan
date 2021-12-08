class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> groupMap = new HashMap<>();
        Map<Integer, Set<Character>> verticalMap = new HashMap<>();
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        initMap(groupMap);
        initMap(verticalMap);
        initMap(rowMap);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int idx = getGroup(i, j);
                char ch = board[i][j];
                if (ch != '.') {
                    if (groupMap.get(idx).contains(ch) && verticalMap.get(j).contains(ch) && rowMap.get(i).contains(ch))      {
                        groupMap.get(idx).remove(ch);
                        verticalMap.get(j).remove(ch);
                        rowMap.get(i).remove(ch);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void initMap(Map<Integer, Set<Character>> map) {
        for (int i = 0; i < 9; i++) {
            map.put(i, new HashSet<>());
            for (int j = 1; j <= 9; j++) {
                map.get(i).add((char) ('0' + j));
            }
        }
    }

    public int getGroup(int i, int j) {
        return j / 3 + i / 3 * 3;
    }
}
