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
    public void reorderList(ListNode head) {
        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode slow = head;
        ListNode quick = head;
        do {
            slow = slow.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
            }
        } while (quick != null && quick.next != null);
        if (slow == null) {
            return;
        }
        ListNode temp = slow.next;
        slow.next = null;
        slow = temp;
        while (slow != null) {
            stack.addLast(slow);
            slow = slow.next;
        }
        quick = head;
        while (!stack.isEmpty()) {
            temp = quick.next;
            quick.next = stack.pollLast();
            quick.next.next = temp;
            quick = quick.next.next;
        }
    }
}
