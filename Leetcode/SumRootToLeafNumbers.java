public class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode p, int res){
        if(p == null){
            return 0;
        }
        if(p.left == null && p.right == null){
            return res * 10 + p.val;
        }
        return helper(p.left, res * 10 + p.val) + helper(p.right, res * 10 + p.val);
    }
}
