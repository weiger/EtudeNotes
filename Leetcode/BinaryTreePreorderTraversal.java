/*
 * Given a binary tree, return the preorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].

 * Note: Recursive solution is trivial, could you do it iteratively? 
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
public BinaryTreePreorderTraversal {
    public void helper(TreeNode root, ArrayList<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }

    public ArrayList<Integer> preorderTraversal_1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }

/******************************************************************/
    
    public ArrayList<Integer> preorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                res.add(root.val);
                if(root.right != null)
                    stack.push(root.right);
                root = root.left;
            }
            else
                root = stack.pop();
        }
        return res;
    }
}
//Morris
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null){
            if (cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;
                if (prev.right == null){
                    res.add(cur.val);
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
