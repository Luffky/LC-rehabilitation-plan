class Solution {
    public void solveSudoku(char[][] board) {
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
                    groupMap.get(idx).remove(ch);
                    verticalMap.get(j).remove(ch);
                    rowMap.get(i).remove(ch);
                }
            }
        }
        helper(board, 0, 0, groupMap, verticalMap, rowMap);
    }

    public boolean helper(char[][] board, int i, int j, Map<Integer, Set<Character>> groupMap, Map<Integer, Set<Character>> verticalMap,Map<Integer, Set<Character>> rowMap) {
        char ch = board[i][j];
        if (ch == '.') {
            int idx = getGroup(i, j);
            Set<Character> set = new HashSet<>();
            set.addAll(groupMap.get(idx));
            set.retainAll(verticalMap.get(j));
            set.retainAll(rowMap.get(i));
            List<Character> list = new ArrayList<>(set);
            for (char element : list) {
                groupMap.get(idx).remove(element);
                verticalMap.get(j).remove(element);
                rowMap.get(i).remove(element);
                board[i][j] = element;
                boolean result = false;
                if (j < 8) {
                    result = helper(board, i, j + 1, groupMap, verticalMap, rowMap);
                } else if (i < 8) {
                    result = helper(board, i + 1, 0, groupMap, verticalMap, rowMap);
                } else {
                    return true;
                }
                if (result) {
                    return true;
                }
                board[i][j] = '.';
                groupMap.get(idx).add(element);
                verticalMap.get(j).add(element);
                rowMap.get(i).add(element);   
            }
            return false;
        } else {
            if (j < 8) {
                return helper(board, i, j + 1, groupMap, verticalMap, rowMap);
            } else if (i < 8) {
                return helper(board, i + 1, 0, groupMap, verticalMap, rowMap);
            } else {
                return true;
            }
        }
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
