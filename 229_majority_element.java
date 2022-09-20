import java.util.List;

/*
 * @lc app=leetcode.cn id=229 lang=java
 *
 * [229] 多数元素 II
 */

// @lc code=start
class Solution {
    class Tuple {
        int val;
        int num;
        public Tuple(int val, int num) {
            this.val = val;
            this.num = num;
        }
    }
    public List<Integer> majorityElement(int[] nums) {
        Tuple[] tuples = new Tuple[2];
        for (int i : nums) {
            if (tuples[0] != null && tuples[0].val == i) {
                tuples[0].num++;
            } else if (tuples[1] != null && tuples[1].val == i) {
                tuples[1].num++;
            } else if (tuples[0] == null) {
                tuples[0] = new Tuple(i, 1);
            } else if (tuples[1] == null) {
                tuples[1] = new Tuple(i, 1);
            } else {
                tuples[0].num--;
                tuples[1].num--;
                if (tuples[0].num == 0) {
                    tuples[0] = null;
                }
                if (tuples[1].num == 0) {
                    tuples[1] = null;
                }
            }
        }
        List<Integer> ret = new LinkedList<>();
        if (IsMajority(nums, tuples[0])) {
            ret.add(tuples[0].val);
        }
        if (IsMajority(nums, tuples[1])) {
            ret.add(tuples[1].val);
        }
        return ret;
    }
    public boolean IsMajority(int[] nums, Tuple tuple) {
        if (tuple != null) {
            int val = tuple.val;
            int cnt = 0;
            for (int i : nums) {
                if (i == val) {
                    cnt++;
                }
            }
            return cnt > nums.length / 3;
        } else {
            return false;
        }
    }
}
// @lc code=end

