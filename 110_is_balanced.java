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
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return flag;
    }

    public int depth(TreeNode cur) {
        if (cur == null || flag == false) {
            return 0;
        }
        int leftDepth = depth(cur.left);
        int rightDepth = depth(cur.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            flag = false;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
