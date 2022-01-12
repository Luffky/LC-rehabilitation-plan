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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if (s1 > e1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[s1]);
        int index = 0;
        for (int i = s2; i <= e2; i++) {
            if (inorder[i] == preorder[s1]) {
                index = i;
                break;
            }
        }
        TreeNode left = helper(preorder, inorder, s1 + 1, s1 + index - s2, s2, index - 1);
        TreeNode right = helper(preorder, inorder, s1 + index - s2 + 1, e1, index + 1, e2);
        root.left = left;
        root.right = right;
        return root;
    }
}
