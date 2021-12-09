class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new LinkedList<>();
        helper(candidates, target, 0, ret, new LinkedList<Integer>());
        return ret;
    }

    public void helper(int[] candidates, int target, int index, List<List<Integer>> ret, LinkedList<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }
        int originTarget = target;
        int val = candidates[index];
        do {
            helper(candidates, target, index + 1, ret, list);
            target -= val;
            list.add(val);
        } while (target >= 0);
        while (target < originTarget) {
            list.pollLast();
            target += val;
        }
    }
}
