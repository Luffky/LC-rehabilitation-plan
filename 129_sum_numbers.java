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
    int ret = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ret;
    }

    public void helper(TreeNode root, int cur) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ret += cur * 10 + root.val;
            return;
        } else {
            if (root.left != null) {
                helper(root.left, cur * 10 + root.val);
            }
            if (root.right != null) {
                helper(root.right, cur * 10 + root.val);
            }
        }
    }
}
