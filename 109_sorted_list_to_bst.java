/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode cur;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int length = 0;
        for (ListNode fast = head; fast != null;) {
            fast = fast.next;
            length++;
        }
        return helper(0, length - 1);
    }

    public TreeNode helper(int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode();
        root.left = helper(s, m - 1);
        root.val = cur.val;
        cur = cur.next;
        root.right = helper(m + 1, e);
        return root;
    }
}
