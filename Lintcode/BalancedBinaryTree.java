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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode p){
        if(p == null){
            return 0;
        }
        return 1 + Math.max(height(p.left), height(p.right));
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        return isBalance(root) >= 0;
    }
    public int isBalance(TreeNode p){
        if(p == null){
            return 0;
        }
        int left = isBalance(p.left);
        int right = isBalance(p.right);
        if(left == -1 || right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
