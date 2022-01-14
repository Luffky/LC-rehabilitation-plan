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
    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, new LinkedList<>());
        return ret;
    }
    public void helper(TreeNode root, int targetSum, LinkedList<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (targetSum - root.val == 0) {
                list.addLast(root.val);
                ret.add(new LinkedList(list));
                list.pollLast();
            }
        } else {
            if (root.left != null) {
                list.addLast(root.val);
                helper(root.left, targetSum - root.val, list);
                list.pollLast();
            }
            if (root.right != null) {
                list.addLast(root.val);
                helper(root.right, targetSum - root.val, list);
                list.pollLast();
            }
        }
    }
}
