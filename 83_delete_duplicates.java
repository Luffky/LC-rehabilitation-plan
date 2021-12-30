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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumy = new ListNode(-1);
        int prev = -200;
        ListNode prevNode = dumy;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val != prev) {
                prev = cur.val;
                prevNode.next = cur;
                prevNode = prevNode.next;
            }
        }
        prevNode.next = null;
        return dumy.next;
    }
}
