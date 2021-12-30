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
        dumy.next = head;
        boolean flag = false;
        int prev = -200;
        ListNode prevNode = dumy;
        for (ListNode cur = dumy; cur.next != null; cur = cur.next) {
            if (cur.next.val != prev) {
                if (!flag) {
                    prevNode = cur;
                } else {
                    prevNode.next = cur.next;
                }
                flag = false;
                prev = cur.next.val;
            } else if (cur.next.val == prev) {
                flag = true;
            }
        }
        if (flag) {
            prevNode.next = null;
        }
        return dumy.next;
    }
}
