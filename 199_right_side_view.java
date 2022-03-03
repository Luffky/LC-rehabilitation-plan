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
    List<Integer> ret;
    public List<Integer> rightSideView(TreeNode root) {
        ret = new LinkedList<>();
        if (root == null) {
            return ret;
        }
        helper(root, 0);
        return ret;
    }
    public void helper(TreeNode cur, int level) {
        if (level == ret.size()) {
            ret.add(cur.val);
        }
        if (cur.right != null) {
            helper(cur.right, level + 1);
        }
        if (cur.left != null) {
            helper(cur.left, level + 1);
        }
    }
}
