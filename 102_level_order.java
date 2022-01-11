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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode sentinel = new TreeNode(-1);
        queue.addLast(root);
        queue.addLast(sentinel);
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur == sentinel) {
                if (!queue.isEmpty()) {
                    queue.addLast(sentinel);
                    ret.add(list);
                    list = new LinkedList<>();
                    continue;
                } else {
                    ret.add(list);
                    break;
                }
            }
            list.add(cur.val);
            if (cur.left != null) {
                queue.addLast(cur.left);
            } 
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        return ret;
    }
}
