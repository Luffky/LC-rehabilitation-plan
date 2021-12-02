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
    public class Element {
        int index;
        ListNode node;
        Element(int index, ListNode node) {
            this.index = index;
            this.node = node;
        }
    }
    Element[] heap;
    int length;

    public ListNode mergeKLists(ListNode[] lists) {
        init(lists);
        makeHeap();
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (length > 0) {
            int nodeIndex = heap[0].index;
            cur.next = heap[0].node;
            cur = cur.next;
            if (lists[nodeIndex] != null) {
                lists[nodeIndex] = lists[nodeIndex].next;
                insertHeap(lists[nodeIndex], nodeIndex);
            } else {
                insertHeap(null, 0);
            }
        }
        return head.next;
    }

    public void init(ListNode[] lists) {
        heap = new Element[lists.length];
        int j = 0;
        for (int i = 0; i < heap.length; i++) {
            if (lists[i] != null) {
                heap[j++] = new Element(i, lists[i]);
            }
        }
        length = j;
    }

    public void makeHeap() {
        for (int i = length / 2 - 1; i >= 0; i--) {
            up2Down(i);
        }
    }

    public void insertHeap(ListNode newNode, int index) {
        if (newNode == null) {
            heap[0] = heap[length - 1];
            length--;
        } else {
            heap[0] = new Element(index, newNode);
        }
        up2Down(0);
    }

    public int swap(int i) {
        int left = (i + 1) * 2 - 1;
        int right = (i + 1) * 2;
        int minVal = heap[i].node.val;
        int minIndex = i;
        if (left < length && heap[left].node.val < minVal) {
            minVal = heap[left].node.val;
            minIndex = left;
        }
        if (right < length && heap[right].node.val < minVal) {
            minVal = heap[right].node.val;
            minIndex = right;
        }
        Element temp = heap[minIndex];
        heap[minIndex] = heap[i];
        heap[i] = temp;
        return minIndex;
    }

    public void up2Down(int i) {
        while (i < length) {
            int newI = swap(i);
            if (newI == i) {
                break;
            }
            i = newI;
        }
    }
}
