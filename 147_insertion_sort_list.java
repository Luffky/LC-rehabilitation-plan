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
    public ListNode insertionSortList(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        for (ListNode cur = dump; cur.next != null; ) {
            if (cur == dump || cur.next.val >= cur.val) {
                cur = cur.next;
                continue;
            }
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            for (ListNode cur2 = dump; ; cur2 = cur2.next) {
                if (temp.val <= cur2.next.val) {
                    temp.next = cur2.next;
                    cur2.next = temp;
                    break;
                } 
            }
        }
        return dump.next;
    }
}
