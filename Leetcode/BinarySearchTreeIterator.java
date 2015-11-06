// Inordere
public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode cur;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
