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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //计算总层数
        int totalLevel = mostBottomLevel(root, 0);
        //计算除最后一层外的节点个数
        int totalCount = (int) Math.pow(2, totalLevel - 1) - 1;
        //计算总结点数
        int count = (int) Math.pow(2, totalLevel - 2);
        return findRightestNode(root, 1, count, totalCount, totalLevel);
    }
    public int findRightestNode(TreeNode root, int curLevel, int count, int totalCount, int totalLevel) {
        if (root.left == null && root.right == null) {
            return totalCount + 1;
        }
        if (mostBottomLevel(root.right, curLevel) == totalLevel) {
            return findRightestNode(root.right, curLevel + 1, count / 2, totalCount + count, totalLevel);
        } else {
            return findRightestNode(root.left, curLevel + 1, count / 2, totalCount, totalLevel);
        }
    }
    public int mostBottomLevel(TreeNode root, int curLevel) {
        while (root != null) {
            root = root.left;
            curLevel++;
        }
        return curLevel;
    }
}
