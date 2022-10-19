/*
 * @lc app=leetcode.cn id=310 lang=java
 *
 * [310] 最小高度树
 */

// @lc code=start
class Solution {
    class TreeNode {
        int index;
        int[] max2;
        TreeNode maxChild;
        List<TreeNode> children;
        int height;
        public TreeNode(int index) {
            this.index = index;
            max2 = new int[2];
            children = new LinkedList<>();
        }
    }
    List<Integer> ret;
    int min;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        TreeNode[] nodes = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new TreeNode(i);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].children.add(nodes[edge[1]]);
            nodes[edge[1]].children.add(nodes[edge[0]]);
        }
        min = n;
        ret = new LinkedList<>();
        calHeight(nodes[0], null);
        calHeight2(nodes[0], null, 0);
        return ret;
    }

    public int calHeight(TreeNode cur, TreeNode last) {
        int height = 0;
        for (TreeNode child : cur.children) {
            if (child == last) {
                continue;
            }
            int h = calHeight(child, cur);
            height = Math.max(height, h);
            if (h > cur.max2[0]) {
                cur.max2[1] = cur.max2[0];
                cur.max2[0] = h;
                cur.maxChild = child;
            } else if (h > cur.max2[1]) {
                cur.max2[1] = h;
            }
        }
        cur.height = height;
        return height + 1;
    }

    public void calHeight2(TreeNode cur, TreeNode last, int height) {
        cur.height = Math.max(cur.height, height);
        if (cur.height < min) {
            min = cur.height;
            ret.clear();
            ret.add(cur.index);
        } else if (cur.height == min) {
            ret.add(cur.index);
        }
        for (TreeNode child : cur.children) {
            if (child == last) {
                continue;
            }
            int maxHeight = cur.max2[0];
            if (child == cur.maxChild) {
                maxHeight = cur.max2[1];
            }
            if (min >= Math.max(height, maxHeight) + 1) {
                calHeight2(child, cur, Math.max(height, maxHeight) + 1);
            }
        }
    }

}
// @lc code=end

