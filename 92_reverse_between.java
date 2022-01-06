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
    ListNode tmpNode1 = null;
    ListNode tmpNode2 = null;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dumy = new ListNode(-1);
        dumy.next = head;
        int num = 1;
        for (ListNode cur = dumy; cur != null; cur = cur.next) {
            if (num == left) {
                reverseListNode(cur.next, right - left);
                cur.next.next = tmpNode2;
                cur.next = tmpNode1;
            }
            num++;
        }
        return dumy.next;
    }

    public ListNode reverseListNode(ListNode cur, int remain) {
        if (remain != 0) {
            ListNode ret = reverseListNode(cur.next, remain - 1);
            ret.next = cur;
            return cur;
        } else {
            tmpNode1 = cur;
            tmpNode2 = cur.next;
            return cur;
        }
    }
}
