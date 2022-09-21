/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ancestor;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return ancestor;
    }
    public boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean leftHas = helper(root.left, p, q);
        if (ancestor != null) {
            return true;
        }
        if ((root == p || root == q) && leftHas) {
            ancestor = root;
            return true;
        }
        boolean rightHas = helper(root.right, p, q);
        if (ancestor != null) {
            return true;
        }
        if ((root == p || root == q || leftHas) && rightHas) {
            ancestor = root;
            return true;
        }
        return root == p || root == q || leftHas || rightHas;
    }
}
// @lc code=end

