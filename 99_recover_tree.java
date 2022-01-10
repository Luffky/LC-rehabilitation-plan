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
    TreeNode last = null;
    TreeNode swap = null;
    TreeNode swap2 = null;
    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = swap.val;
        swap.val = swap2.val;
        swap2.val = temp;
    }
    public void inorderTraversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        inorderTraversal(cur.left);
        if (last != null && last.val > cur.val) {
            if (swap == null) {
                swap = last;
                swap2 = cur;
            } else {
                swap2 = cur;
            }
        }
        last = cur;
        inorderTraversal(cur.right);
    }
}
