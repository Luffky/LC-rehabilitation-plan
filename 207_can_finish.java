class Solution {
    class Node {
        int color;
        LinkedList<Node> neighbour;
        int index;
        public Node(int index) {
            this.index = index;
            color = 0;
            neighbour = new LinkedList<Node>();
        }
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][0]].neighbour.add(nodes[prerequisites[i][1]]);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (nodes[i].color == 0) {
                boolean hasCycle = dfs(nodes[i]);
                if (hasCycle) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(Node cur) {
        if (cur.color == 0) {
            cur.color = 1;
            for (int i = 0; i < cur.neighbour.size(); i++) {
                Node nei = cur.neighbour.get(i);
                if (nei.color == 1) {
                    return true;
                } else if (nei.color == 0) {
                    boolean hasCycle = dfs(nei);
                    if (hasCycle) {
                        return true;
                    }
                }
            }
            cur.color = 2;
        }
        return false;
    }
}
