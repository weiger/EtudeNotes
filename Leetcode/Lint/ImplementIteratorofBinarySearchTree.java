/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    TreeNode cur;
    Stack<TreeNode> stack;
    public Solution(TreeNode root) {
        stack = new Stack<TreeNode>();
        cur = root;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (cur!=null || !stack.isEmpty());
    }
    
    //@return: return next node
    public TreeNode next() {
        while(cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node;
    }
}
