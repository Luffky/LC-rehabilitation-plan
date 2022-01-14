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
    int minDepth = -1;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, 1);
        return minDepth;
    }
    public void helper(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            if (minDepth == -1) {
                minDepth = depth;
            } else {
                minDepth = Math.min(minDepth, depth);
            }
        } else {
            if (root.left != null) {
                helper(root.left, depth + 1);
            }
            if (root.right != null) {
                helper(root.right, depth + 1);
            }
        }
    }
}
