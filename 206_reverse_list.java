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
class Solution {
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
        helper(head);
        return newHead;
    }
    public ListNode helper(ListNode head) {
        if (head == null || head.next == null) {
            newHead = head;
            return head;
        } else {
            ListNode next = helper(head.next);
            head.next = null;
            next.next = head;
            return head;
        }
    }
}
