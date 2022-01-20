class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        ret.add(list);
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevList = ret.get(i - 1);
            List<Integer> curList = new LinkedList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    curList.add(1);
                } else {
                    curList.add(prevList.get(j - 1) + prevList.get(j));
                }
            }
            ret.add(curList);
        }
        return ret;
    }
}
