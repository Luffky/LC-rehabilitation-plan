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
    class ReturnVal {
        int min;
        int max;
        ReturnVal(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    boolean flag = false;
    public boolean isValidBST(TreeNode root) {
        inorderTraversal(root);
        return !flag;
    }

    public ReturnVal inorderTraversal(TreeNode cur) {
        if (cur == null) {
            return null;
        }
        ReturnVal left = inorderTraversal(cur.left);
        ReturnVal right = inorderTraversal(cur.right);
        if (left == null && right == null) {
            return new ReturnVal(cur.val, cur.val);
        } else if (right == null) {
            if (left.max >= cur.val) {
                flag = true;
                return null;
            } else {
                return new ReturnVal(left.min, cur.val);
            } 
        } else if (left == null) {
             if (right.min <= cur.val) {
                 flag = true;
                 return null;
             } else {
                 return new ReturnVal(cur.val, right.max);
             }
        } else {
            if (right.min <= cur.val || left.max >= cur.val) {
                flag = true;
                return null;
            } else {
                return new ReturnVal(left.min, right.max);
            }
        }
    }
}
