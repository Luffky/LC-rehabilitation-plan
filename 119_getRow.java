class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new LinkedList<>();
        prevList.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curList = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    curList.add(1);
                } else {
                    curList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            prevList = curList;
        }
        return prevList;
    }
}
