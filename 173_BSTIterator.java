/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    TreeNode root;
    LinkedList<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new LinkedList<>();
        cur = root;
        while (cur.left != null) {
            stack.addLast(cur);
            cur = cur.left;
        }
    }
    
    public int next() {
        int temp = cur.val;
        if (cur.right != null) {
            cur = cur.right;
            while (cur.left != null) {
                stack.addLast(cur);
                cur = cur.left;
            }
        } else {
            if (!stack.isEmpty()) {
                cur = stack.pollLast();
            } else {
                cur = null;
            }
        }
        return temp;
    }
    
    public boolean hasNext() {
        return cur != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
