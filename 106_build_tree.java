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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] postorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[e1]);
        int index = 0;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == postorder[e1]) {
                index = i;
                break;
            }
        }
        TreeNode right = helper(postorder, inorder, e1 - e2 + index, e1 - 1, index + 1, e2);
        TreeNode left = helper(postorder, inorder, s1, e1 - e2 + index - 1, s2, index - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
