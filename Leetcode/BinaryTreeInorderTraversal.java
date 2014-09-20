/*
 * Given a binary tree, return the inorder traversal of its nodes' values.

 * For example:
 * Given binary tree {1,#,2,3},

 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,3,2].
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
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        if(root==null) return res;
        helper(res,root);
        return res;
    }
    public void helper(List<Integer> res,TreeNode p){
        if(p!=null){
            helper(res,p.left);
            res.add(p.val);
            helper(res,p.right);
        }
    }
}
public class BinaryTreeInorderTraversal {
/************************ updated 2013/11/30 ************************/
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root != null) {
            res = inorderTraversal(root.left);
            res.add(root.val);
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }

/**************************************************************/

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode cur = root;
            while(!stack.isEmpty() || cur != null) {
                if(cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return res;
    }
/**************************************************************/
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeIterator it = TreeIterator.iterator(root);
        while(it.hasNext()){
            TreeNode cur = it.next();
            res.add(cur.val);
        }
        return res;
    }
}

class TreeIterator {

        private Stack<TreeNode> stack = new Stack<>();
        private TreeNode current;
    
        private TreeIterator(TreeNode argRoot) {
            current = argRoot;
        }
    
        public TreeNode next() {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
    
    
            current = stack.pop();
            TreeNode node = current;
            current = current.right;
    
            return node;
        }
    
        public boolean hasNext() {
            return (!stack.isEmpty() || current != null);
        }
    
        public static TreeIterator iterator(TreeNode root) {
            return new TreeIterator(root);
        }
}
/**************************************************************/

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left != null) {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur) 
                    prev = prev.right;
                if(prev.right == cur) {
                    result.add(cur.val);
                    cur = cur.right;
                    prev.right = null;
                } else {
                    prev.right = cur;
                    cur = cur.left;
                }
            } else {
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
