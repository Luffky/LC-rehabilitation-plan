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
    int max = 0;
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return max;
    }
    public void helper(TreeNode cur, int depth) {
        max = Math.max(max, depth);
        if (cur.left != null) {
            helper(cur.left, depth + 1);
        }
        if (cur.right != null) {
            helper(cur.right, depth + 1);
        }
    }
}
