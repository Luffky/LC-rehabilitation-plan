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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
    }
    public TreeNode helper(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else {
            TreeNode lMax = null;
            TreeNode rMax = null;
            if (root.left != null) {
                lMax = helper(root.left);
            }
            if (root.right != null) {
                rMax = helper(root.right);
            }
            if (lMax != null) {
                lMax.right = root.right;
                root.right = root.left;
            }
            root.left = null;
            if (rMax != null) {
                return rMax;
            } else {
                return lMax;
            }
        }
    }
}
