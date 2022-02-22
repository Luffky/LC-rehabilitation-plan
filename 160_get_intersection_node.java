/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur = headA;
        while (cur.next != null) {
            cur = cur.next;
        }
        ListNode temp = cur;
        cur.next = headB;
        ListNode slow = headA;
        ListNode quick = headA;
        do {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
        } while (quick != null && quick != slow);
        if (quick == null) {
            temp.next = null;
            return null;
        }
        quick = headA;
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        temp.next = null;
        return quick;
    }
}
