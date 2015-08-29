public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    public int helper(TreeNode p){
        if(p == null){
            return 0;
        }
        int L = helper(p.left);
        int R = helper(p.right);
        int sum = p.val + Math.max(L + R, Math.max(L, Math.max(0, R)));
        max = Math.max(max, sum);
        return p.val + Math.max(L, Math.max(0, R));
    }
}
