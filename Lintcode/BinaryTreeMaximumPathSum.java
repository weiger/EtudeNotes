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
        // write your code here
        helper(root);
        return res;
    }
    
    public int helper(TreeNode p){
        if(p == null){
            return 0;
        }
        int L = helper(p.left);
        int R = helper(p.right);
        int sum = p.val + Math.max(L + R, Math.max(0, Math.max(L, R)));
        res = Math.max(res, sum);
        return p.val + Math.max(0, Math.max(L, R));
    }
}
