class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new LinkedList<>();
        helper(candidates, target, 0, false, new LinkedList(), ret);
        return ret;
    }

    public void helper(int[] candidates, int target, int index, boolean choosePrev, LinkedList<Integer> list, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        } else if (index >= candidates.length) {
            return;
        }
        int val =candidates[index];
        helper(candidates, target, index + 1, false, list, ret);
        if ((target == val || target >= 2 * val) && canChoose(candidates, index, choosePrev)){
            list.add(val);
            helper(candidates, target - val, index + 1, true, list, ret);
            list.pollLast();
        }
    }
    
    public boolean canChoose(int[] candidates, int index, boolean choosePrev) {
        if (index == 0) {
            return true;
        } else {
            if (candidates[index - 1] != candidates[index]) {
                return true;
            } else if (choosePrev) {
                return true;
            } else {
                return false;
            }
        }
    }
}
