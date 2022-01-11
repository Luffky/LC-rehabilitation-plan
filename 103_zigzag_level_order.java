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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue.addLast(root);
        List<Integer> list = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        boolean rightBegin = true;
        int num = 1;
        int nowNum = 0;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            list.add(cur.val);
            num--;
            if (!rightBegin) {
                if (cur.right != null) {
                    nowNum++;
                    queue2.addFirst(cur.right);
                } 
                if (cur.left != null) {
                    nowNum++;
                    queue2.addFirst(cur.left);
                }
            } else {
                if (cur.left != null) {
                    nowNum++;
                    queue2.addFirst(cur.left);
                } 
                if (cur.right != null) {
                    nowNum++;
                    queue2.addFirst(cur.right);
                }
            }
            if (num == 0) {
                num = nowNum;
                nowNum = 0;
                rightBegin = !rightBegin;
                ret.add(list);
                queue = queue2;
                queue2 = new LinkedList<>();
                list = new LinkedList<>();
            }
        }
        return ret;
    }
}
