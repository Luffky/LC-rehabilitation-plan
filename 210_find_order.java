class Solution {
    class Node {
        int color;
        Set<Node> neighbour;
        Set<Node> neighbour2;
        int index;
        public Node(int index) {
            this.index = index;
            color = 0;
            neighbour = new HashSet<Node>();
            neighbour2 = new HashSet<Node>();
        }
    }

    public static Comparator<Node> idComparator = new Comparator<Node>(){
        @Override
        public int compare(Node c1, Node c2) {
            return (int) (c1.neighbour2.size() - c2.neighbour2.size());
        }

    };

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][1]].neighbour.add(nodes[prerequisites[i][0]]);
            nodes[prerequisites[i][0]].neighbour2.add(nodes[prerequisites[i][1]]);
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(numCourses, idComparator);
        for (int i = 0; i < numCourses; i++) {
            queue.add(nodes[i]);
        }
        LinkedList<Integer> ret = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.neighbour2.size() != 0) {
                return new int[0];
            }
            ret.addLast(cur.index);
            for (Node neighbour : cur.neighbour) {
                neighbour.neighbour2.remove(cur);
                queue.remove(neighbour);
                queue.add(neighbour);
            }
        }
        int[] arr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            arr[i] = ret.pollFirst();
        }
        return arr;
    }
}
