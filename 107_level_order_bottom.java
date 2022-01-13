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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int num = 1;
        int numCur = 0;
        List<Integer> list = new LinkedList<>();
        LinkedList<List<Integer>> ret = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            list.add(cur.val);
            num--;
            if (cur.left != null) {
                queue.addLast(cur.left);
                numCur++;
            } 
            if (cur.right != null) {
                queue.addLast(cur.right);
                numCur++;
            }
            if (num == 0) {
                ret.addFirst(list);
                list = new LinkedList<>();
                num = numCur;
                numCur = 0;
            }
        }
        return ret;
    }
}
