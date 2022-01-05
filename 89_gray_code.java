class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        ret.add(0);
        ret.add(1);
        int val = 2;
        for (int i = 1; i < n; i++) {
            for (int j = ret.size() - 1; j >= 0; j--) {
                ret.add(ret.get(j) + val);
            }
            val *= 2;
        }
        return ret;
    }
}
