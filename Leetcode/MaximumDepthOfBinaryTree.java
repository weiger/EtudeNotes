/*
 * Given a binary tree, find its maximum depth.

 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int cur = 1;
        int next = 0;
        int res = 1;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            if(n.left!=null){
                next++;
                queue.offer(n.left);
            }

            if(n.right!=null){
                next++;
                queue.offer(n.right);
            }
            cur--;
            if(cur==0 && next!=0){
                cur = next;
                next = 0;
                res++;
            }
        }
        return res;
    }
/************************************************************************/

    public int maxDepth(TreeNode root) {
        if(root == null) 
            return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int depth = 0;
        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur) {
                if(cur.left != null)
                    stack.push(cur.left);
                else if(cur.right != null)
                    stack.push(cur.right);
            }
            else if(cur.left == prev) {
                if(cur.right != null)
                    stack.push(cur.right);
            }
            else
                stack.pop();
            prev = cur;
            if(stack.size() > depth)
                depth = stack.size();
        }
        return depth;
    }
}   
