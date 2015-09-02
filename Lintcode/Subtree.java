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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null) return true;
        if(T1 == null) return false;
        return isSame(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    public boolean isSame(TreeNode p1, TreeNode p2){
        if(p1 == null && p2 == null) return true;
        if(p1 == null || p2 == null) return false;
        if(p1.val == p2.val) return isSame(p1.left, p2.left) &&isSame(p1.right, p2.right);
        else return false;
    }
}
