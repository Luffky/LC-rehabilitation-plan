class Solution {
    List<List<Integer>> ret;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ret = new LinkedList<>();
        helper(1, k, n, new LinkedList<>());
        return ret;
    }
    public void helper(int index, int k, int n, LinkedList<Integer> list) {
        if (n == 0 && k == 0) {
            ret.add(new LinkedList<>(list));
            return;
        } 
        if (index > 9 || k == 0) {
            return;
        }
        for (int i = index; i <= 9; i++) {
            if (n < i) {
                return;
            }
            n -= i;
            list.addLast(i);
            helper(i + 1, k - 1, n, list);
            list.removeLast();
            n += i;
        }
    }
}
