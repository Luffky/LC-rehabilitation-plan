/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        Node newCur = newHead;
        for (Node cur = head; cur != null; cur = cur.next, newCur = newCur.next) {
            if (cur.next != null) {
                if (map.containsKey(cur.next)) {
                    newCur.next = map.get(cur.next);
                } else {
                    newCur.next = new Node(cur.next.val);
                    map.put(cur.next, newCur.next);
                }
            }
            if (cur.random != null) {
                if (map.containsKey(cur.random)) {
                    newCur.random = map.get(cur.random);
                } else {
                    newCur.random = new Node(cur.random.val);
                    map.put(cur.random, newCur.random);
                }
            }
        }
        return newHead;

    }
}
