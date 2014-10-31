/*
 * Given a binary tree, return the postorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].

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
public class BinaryTreePostorderTraversal {
    public void helper(ArrayList<Integer> list, TreeNode root) {
        if(root == null)
            return;
        if(root.left != null)
            helper(list, root.left);
        if(root.right != null)
            helper(list, root.right);
        list.add(root.val);
    }

    public ArrayList<Integer> postorderTraversal_1(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        recfunc(res,root);
        return res;
    }
    public void recfunc(ArrayList<Integer> AL,TreeNode root){
        if(root!=null){
            recfunc(AL,root.left);
            recfunc(AL,root.right);
            AL.add(root.val);
        }
    }
}
/********************************************************************/ 

    public ArrayList<Integer> postorderTraversal_2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode next =stack.peek();
            if(next.left == root || next.right == root || (next.left == null && next.right == null)) {
                stack.pop();
                res.add(next.val);
                root = next;
            }
            else {
                if(next.right != null)
                    stack.push(next.right);
                if(next.left != null)
                    stack.push(next.left);
            }
        }
        return res;
    }   
}
//Morris
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        TreeNode dump = new TreeNode(0);;
        dump.left = root;
        TreeNode cur = dump, prev = null;
        while (cur!=null)
        {
            if (cur.left == null){
                cur = cur.right;
            }
            else{
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    printReverse(cur.left, prev,res); 
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    } 
    public void reverse(TreeNode from, TreeNode to)
    {
        if (from == to)
            return;
        TreeNode x = from, y = from.right, z;
        while (true){
            z = y.right;
            y.right = x;
            x = y;
            y = z;
            if (x == to)
                break;
        }
    }
    public void printReverse(TreeNode from, TreeNode to,ArrayList<Integer> res){
        reverse(from, to);
        
        TreeNode p = to;
        while (true){
            res.add(p.val);
            if (p == from)
                break;
            p = p.right;
        }
        reverse(to, from);
    }
}
