class Solution {
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n, 1, k, new LinkedList<>());
        return ret;
    }

    public void helper(int n, int x, int k, LinkedList<Integer> list) {
        if (k == 0) {
            ret.add(new LinkedList<>(list));
            return;
        }
        for (int i = x; i <= n; i++) {
            if (n - i < k - 1) {
                break;
            }
            list.addLast(i);
            helper(n, i + 1, k - 1, list);
            list.pollLast();
        }
    }
}
