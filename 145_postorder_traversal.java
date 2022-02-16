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
    List<Integer> ret = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return ret;
    }
    public void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }
        helper(cur.left);
        helper(cur.right);
        ret.add(cur.val);
    }
}
