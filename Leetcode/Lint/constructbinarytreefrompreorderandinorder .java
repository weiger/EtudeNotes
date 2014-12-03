/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note
You may assume that duplicates do not exist in the tree
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0)
            return null;
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] pre,int pb,int pe,int[] in,int ib,int ie){
        int i = 0;
        TreeNode root = new TreeNode(pre[pb]);
        while(pre[pb]!=in[ib+i]){
            i++;
        }
        if(i!=0){
            root.left = helper(pre,pb+1,pb+i,in,ib,ib+i-1);
        }
        if(pb+i+1<=pe){
            root.right = helper(pre,pb+i+1,pe,in,ib+i+1,ie);
        }
        return root;
    }
}
