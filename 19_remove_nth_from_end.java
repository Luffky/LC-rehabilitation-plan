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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode targetNode = null;
        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
            n--;
            if (targetNode != null) {
                targetNode = targetNode.next;
            } else if (n == 0) {
                targetNode = head;
            }
        }
        if (targetNode == null) {
            return head.next;
        }
        targetNode.next = targetNode.next.next;
        return head;
    }
}
