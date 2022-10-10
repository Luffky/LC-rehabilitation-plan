import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        sb.append(root.val + ",");
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            if (cur.left != null) {
                queue.add(cur.left);
                sb.append(cur.left.val + ",");
            } else {
                sb.append("#,");
            }
            if (cur.right != null) {
                queue.add(cur.right);
                sb.append(cur.right.val + ",");
            } else {
                sb.append("#,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");
        int idx = 0;
        TreeNode root = new TreeNode(Integer.valueOf(arr[idx++]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.pollFirst();
            String str = arr[idx++];
            if (!str.equals("#")) {
                cur.left = new TreeNode(Integer.valueOf(str));
                queue.add(cur.left);
            }
            str = arr[idx++];
            if (!str.equals("#")) {
                cur.right = new TreeNode(Integer.valueOf(str));
                queue.add(cur.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

