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
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return helper(head, tail);
    }

    public ListNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode quick = head;
        ListNode prev;
        do {
            prev = slow;
            slow = slow.next;
            quick = quick.next;
            if (quick != tail) {
                quick = quick.next;
            }
        } while (quick != tail);
        ListNode left = helper(head, prev);
        ListNode right = helper(slow, quick);
        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dumy = new ListNode(-1);
        ListNode cur = dumy;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val <= right.val) {
                    cur.next = left;
                    left = left.next;
                } else {
                    cur.next = right;
                    right = right.next;
                }
                cur = cur.next;
            } else if (left != null) {
                cur.next = left;
                break;
            } else {
                cur.next = right;
                break;
            }
        }
        return dumy.next;
    }
}
