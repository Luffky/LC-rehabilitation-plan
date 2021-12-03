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
    ListNode temp = null;
    ListNode temp2 = null;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumy = new ListNode(-1, head);
        ListNode cur = dumy;
        while (true) {
            ListNode lastNode = reverseK(cur.next, k - 1);
            //如果是null，说明后面没有k个元素了，未交换位置，直接退出返回即可
            if (lastNode == null) {
                break;
            }
            //当前组的最后一个元素需要连接到下一组元素的开头
            lastNode.next = temp;
            //上一组最后一个元素需要连接到这一组元素的开头
            cur.next = temp2;
            //往后移动一组
            cur = lastNode;
        }
        return dumy.next;
    }

    public ListNode reverseK(ListNode cur, int remain) {
        //当前组元素不足k个
        if (cur == null) {
            return null;
        }
        if (remain > 0) {
            ListNode ret = reverseK(cur.next, remain - 1);
            if (ret != null) { //交换位置
                ret.next = cur;
                return cur;
            } else { //直接返回null
                return null;
            }
        } else {
            //保存当前组的第一个元素和下一组的第一个元素
            temp = cur.next;
            temp2 = cur;
            return cur;
        }
    }
}
