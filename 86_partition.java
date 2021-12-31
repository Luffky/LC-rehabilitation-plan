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
    public ListNode partition(ListNode head, int x) {
        ListNode dumy1 = new ListNode(-1);
        ListNode dumy2 = new ListNode(-1);
        ListNode cur1 = dumy1;
        ListNode cur2 = dumy2;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
            } else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
        }
        cur1.next = dumy2.next;
        cur2.next = null;
        return dumy1.next;
    }
}
