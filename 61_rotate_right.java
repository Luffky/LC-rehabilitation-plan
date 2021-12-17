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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 0;
        ListNode cur = head;
        ListNode tail = null;
        while (cur != null) {
            count++;
            tail = cur;
            cur = cur.next;
        }
        k %= count;
        if (k == 0) {
            return head;
        }

        cur = head;
        int i = 0;
        while (i < count - k - 1) {
            cur = cur.next;
            i++;
        }
        tail.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }
}
