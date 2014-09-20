/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.

 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //Similiar idea from inorder and preorder
 public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null||inorder==null||preorder.length==0||inorder.length==0) return null;
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode helper(int[] preorder,int pbeg,int pend,int[] inorder,int ibeg,int iend){
        int i=0;
        TreeNode root = new TreeNode(preorder[pbeg]);
        while(preorder[pbeg]!=inorder[i+ibeg])
            i++;
        if(i!=0)
            root.left = helper(preorder,pbeg+1,pbeg+i,inorder,ibeg,ibeg+i-1);
        if(pbeg+i+1<=pend)
            root.right = helper(preorder,pbeg+i+1,pend,inorder,ibeg+i+1,iend);
        return root;
    }
}
 
 
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
        TreeNode root = new TreeNode(postorder[pEnd]); 
        int i = 0;
        while(inorder[iEnd - i] != postorder[pEnd]) {
            i++;
        }
        if(i != 0)
            root.right = buildTreeHelper(inorder, iEnd - i + 1, iEnd, postorder, pEnd - i, pEnd - 1);
        if(iEnd - i - 1 >= iStart)
            root.left = buildTreeHelper(inorder, iStart, iEnd - i - 1, postorder, pStart, pEnd - i - 1);
        return root;
    }
}
