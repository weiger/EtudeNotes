/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

Example
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return res;
        helper(root);
        return res;
    }
    public int helper(TreeNode p){
        if(p==null)
            return 0;
        int L = helper(p.left);
        int R = helper(p.right);
        int sub = p.val + Math.max(L+R,Math.max(L,Math.max(0,R)));
        if(sub>res)
            res = sub;
        return p.val + Math.max(L,Math.max(R,0));
    }
}
