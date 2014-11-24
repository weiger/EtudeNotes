/*Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example
Given binary tree A={3,9,20,#,#,15,7}, B={3,#,20,15,7}

A)  3            B)    3 
   / \                  \
  9  20                 20
    /  \                / \
   15   7              15  7
The binary tree A is a height-balanced binary tree, but B is not */


public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root)>=0;
    }
    public int helper(TreeNode p){
        if(p==null)
            return 0;
        int l = helper(p.left);
        int r = helper(p.right);
        if(l<0||r<0)
            return -1;
        if(Math.abs(l-r)>1)
            return -1;
        return 1 + Math.max(l,r);
    }
}
