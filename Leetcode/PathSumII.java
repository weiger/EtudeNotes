/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return

 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        List<Integer> list = new ArrayList<>();
        helper(res,list,root,0,sum);
        return res;
    }
    public void helper(List<List<Integer>> res,List<Integer> list,TreeNode p,int buf,int sum){
        if(p==null)
            return;
        if(buf==sum-p.val && p.left==null && p.right==null){
            list.add(p.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if(p.left!=null){
            list.add(p.val);
            helper(res,list,p.left,buf+p.val,sum);
            list.remove(list.size()-1);
        }
        if(p.right!=null){
            list.add(p.val);
            helper(res,list,p.right,buf+p.val,sum);
            list.remove(list.size()-1);
        }
    }
}
 
 
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,root,sum);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,TreeNode root,int sum){
        if(root==null)
            return;
         list.add(root.val);   
        if(root.val==sum && root.left==null && root.right==null){
            res.add(new ArrayList<Integer>(list));
        }
        helper(res,list,root.left,sum-root.val);
        helper(res,list,root.right,sum-root.val);
        list.remove(list.size()-1);
    }
}

//for reminding
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        ArrayList<Integer> list = new ArrayList<Integer>();
        helper(res,list,root,sum);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,TreeNode root,int sum){
        if(root==null)
            return;
        if(root.val==sum && root.left==null && root.right==null){
            list.add(root.val);
            res.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        helper(res,list,root.left,sum-root.val);
        helper(res,list,root.right,sum-root.val);
        list.remove(list.size()-1);
    }
}
