/*
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

An example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}"
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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(root.left == null && root.right == null)
            return true;
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode p, int min, int max){
        if(p == null)
            return true;
        if(p.val <= min || p.val >= max)
            return false;
        return helper(p.left,min,p.val) && helper(p.right,p.val,max);
    }
}
