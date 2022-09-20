/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第K小的元素
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode result;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, k);
        return result.val;
    }
    public int helper(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int rank = helper(root.left, k);
        if (result != null) {
            return 0;
        }
        if (rank + 1 == k) {
            result = root;
            return 0;
        } else {
            return rank + 1 + helper(root.right, k - rank - 1);
        }
    }
}
// @lc code=end

