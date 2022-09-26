import java.util.Arrays;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
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
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<String> left = binaryTreePaths(root.left);
        List<String> right = binaryTreePaths(root.right);
        if (left == null && right == null) {
            return Arrays.asList(String.valueOf(root.val));
        }
        List<String> ret = new LinkedList<>();
        if (left != null) {
            for (String str : left) {
                ret.add(String.valueOf(root.val) + "->" + str);
            }
        }
        if (right != null) {
            for (String str : right) {
                ret.add(String.valueOf(root.val) + "->" + str);
            }
        }
        return ret;
    }
}
// @lc code=end

