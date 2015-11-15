public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null)
            return root.val == sum;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }
    public boolean helper(TreeNode p, int sum, int target){
        if (p == null) {
            return false;
        }
        sum += p.val;
        if (p.left == null && p.right == null && sum == target) {
            return true;
        }
        return helper(p.left, sum, target) || helper(p.right, sum, target);
    }
}
