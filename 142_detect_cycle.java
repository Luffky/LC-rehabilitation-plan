/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        do {
            slow = slow.next;
            quick = quick.next;
            if (quick == null) {
                return null;
            }
            quick = quick.next;
            if (quick == null) {
                return null;
            }
        } while (slow != quick);
        slow = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
