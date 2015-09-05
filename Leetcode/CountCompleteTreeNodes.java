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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = getLeft(root.left) + 1;
        int right = getRight(root.right) + 1;
        if(left == right) return (2 << (left - 1)) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    public int getLeft(TreeNode p){
        if(p == null){
            return 0;
        }
        int len = 1;
        while(p.left != null){
            len++;
            p = p.left;
        }
        return len;
    }
    
    public int getRight(TreeNode p){
        if(p == null){
            return 0;
        }
        int len = 1;
        while(p.right != null){
            len++;
            p = p.right;
        }
        return len;
    }
}
