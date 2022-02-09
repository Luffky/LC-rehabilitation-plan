/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    LinkedList<Node> queue = new LinkedList<>();
    LinkedList<Node> queue2 = new LinkedList<>();
    Set<Node> greySet = new HashSet<>();
    Set<Node> blackSet = new HashSet<>();
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Node newNode = new Node(node.val);
        greySet.add(node);
        queue.addLast(node);
        queue2.addLast(newNode);
        while (!queue.isEmpty()) {
            Node curNode = queue.pollFirst();
            Node curNode2 = queue2.pollFirst();

            for (Node neighbor : curNode.neighbors) {
                if (!greySet.contains(neighbor)) {
                    Node newNeighbor = new Node(neighbor.val);
                    curNode2.neighbors.add(newNeighbor);
                    newNeighbor.neighbors.add(curNode2);

                    map.put(neighbor, newNeighbor);
                    greySet.add(neighbor);
                    queue.addLast(neighbor);
                    queue2.addLast(newNeighbor);
                } else if (!blackSet.contains(neighbor)) {
                    Node newNeighbor = map.get(neighbor);
                    curNode2.neighbors.add(newNeighbor);
                    newNeighbor.neighbors.add(curNode2);
                }
            }
            blackSet.add(curNode);
        }
        return newNode;
    }
}
