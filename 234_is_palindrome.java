/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
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
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
            if (quick.next != null) {
                quick = quick.next;
            }
        }
        reverseList(slow);
        while (head != slow) {
            if (head.val != quick.val) {
                return false;
            }
            head = head.next;
            quick = quick.next;
        } 
        return true;
    }
    public ListNode reverseList(ListNode cur) {
        if (cur.next == null) {
            return cur;
        }
        reverseList(cur.next).next = cur;
        return cur;
    }
}
// @lc code=end

