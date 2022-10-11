/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
class NumArray {
    class TreeNode {
        int val;
        int s;
        int e;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val, int s, int e) {
            this.val = val;
            this.s = s;
            this.e = e;
        }
    }
    TreeNode root;
    int[] arr;
    public NumArray(int[] nums) {
        arr = nums;
        root = new TreeNode(-1, 0, nums.length - 1);
        this.buildTree(nums, root);
    }

    public void buildTree(int[] nums, TreeNode cur) {
        if (cur.s == cur.e) {
            cur.val = nums[cur.s];
            return;
        }
        int m = (cur.s + cur.e) / 2;
        TreeNode left = new TreeNode(-1, cur.s, m);
        TreeNode right = new TreeNode(-1, m + 1, cur.e);
        cur.left = left;
        cur.right = right;
        this.buildTree(nums, cur.left);
        this.buildTree(nums, cur.right);
        cur.val = cur.left.val + cur.right.val;
    }
    
    public void update(int index, int val) {
        int delta = val - arr[index];
        arr[index] = val;
        TreeNode cur = root;
        while (cur.s != cur.e) {
            cur.val += delta;
            if (index <= cur.left.e) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        cur.val += delta;
    }
    
    public int sumRange(int left, int right) {
        return helper(root, left, right);
    }
    public int helper(TreeNode cur, int left, int right) {
        if (cur.s == left && cur.e == right) {
            return cur.val;
        }
        if (right <= cur.left.e) {
            return helper(cur.left, left, right);
        } else if (left >= cur.right.s) {
            return helper(cur.right, left, right);
        } else {
            return helper(cur.left, left, cur.left.e) + helper(cur.right, cur.right.s, right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
// @lc code=end

