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
    LinkedList<Boolean> list;
    int totalLevel;
    public int countNodes(TreeNode root) {
        list = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        //计算层数
        totalLevel = 0;
        TreeNode curNode = root;
        while (curNode != null) {
            curNode = curNode.left;
            totalLevel++;
        }
        //除最后一层外的节点个数
        int totalCount = (int) Math.pow(2, totalLevel - 1) - 1;
        //二分法开始找最后一层的最右节点位置
        findRightestNode(root, 1);
        int count = (int) Math.pow(2, totalLevel - 2);
        for (boolean isRight : list) {
            if (isRight) {
                totalCount += count;
            }
            count /= 2;
        }
        totalCount++;
        return totalCount;
    }
    public boolean findRightestNode(TreeNode root, int curLevel) {
        if (root.left == null) {
            return curLevel == totalLevel;
        } else if (root.right == null) {
            list.addLast(false);
            boolean has = findRightestNode(root.left, curLevel + 1);
            if (!has) {
                list.removeLast();
            }
            return has;
        } else {
            list.addLast(true);
            if (findRightestNode(root.right, curLevel + 1)) {
                return true;
            }
            list.removeLast();
            list.addLast(false);
            boolean has = findRightestNode(root.left, curLevel + 1);
            if (!has) {
                list.removeLast();
            }
            return has;
        }
    }
}
