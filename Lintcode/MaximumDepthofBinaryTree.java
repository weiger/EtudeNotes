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
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        if(root.left == null){
            return 1 + helper(root.right);
        }
        if(root.right == null){
            return 1 + helper(root.left);
        }
        return 1 + Math.max(helper(root.left), helper(root.right));
    }
    public int helper(TreeNode p){
        if(p == null){
            return 0;
        }
        return 1 + Math.max(helper(p.left), helper(p.right));
    }
}
