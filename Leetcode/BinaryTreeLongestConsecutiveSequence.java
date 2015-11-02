// Not BST
public class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int max = 1;
        if (root.left != null && root.val + 1 == root.left.val) {
            max = Math.max(max, left + 1);
        }
        if (root.right != null && root.val + 1 == root.right.val) {
            max = Math.max(max, right + 1);
        }
        res = Math.max(res, max);
        return max;
    }
}
