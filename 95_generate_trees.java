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
    public List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public List<TreeNode> helper(int start, int end) {
        List<TreeNode> ret = new LinkedList<>();
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = helper(start, i - 1);
            List<TreeNode> rightNodes = helper(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode root = new TreeNode(i, leftNode, rightNode);
                    ret.add(root);
                }
            }
        }
        if (ret.size() == 0) {
            ret.add(null);
        }
        return ret;
    }

}
