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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode ret = new ListNode();
        ListNode cur = ret;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            cur.next = new ListNode();
            cur = cur.next;
            int tmp = n1.val + n2.val + carry;
            carry = 0;
            if (tmp >= 10) {
                cur.val = tmp - 10;
                carry = 1;
            } else {
                cur.val = tmp;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        ListNode n = null;
        if (n1 != null) {
            n = n1;
        } else if (n2 != null) {
            n = n2;
        }
        
        while (n != null) {
            cur.next = new ListNode();
            cur = cur.next;
            int tmp = n.val + carry;
            carry = 0;
            if (tmp >= 10) {
                cur.val = tmp - 10;
                carry = 1;
            } else {
                cur.val = tmp;
            }
            n = n.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return ret.next;
    }
}
