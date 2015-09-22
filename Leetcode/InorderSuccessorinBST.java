/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) return leftMost(p.right);
        TreeNode last = null;
        while (root != null) {
            if (p.val < root.val) {
                last = root;
                root = root.left;
            } else if (p.val > root.val){
                root = root.right;
            } else {
                break;
            }
        }
        return last;
    }
    
    public TreeNode leftMost(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}
