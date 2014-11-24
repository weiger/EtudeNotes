/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
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
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(res,root);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,TreeNode p){
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        cur.offer(p);
        while(!cur.isEmpty()){
            TreeNode now = cur.poll();
            list.add(now.val);
            if(now.left!=null)
                next.offer(now.left);
            if(now.right!=null)
                next.offer(now.right);
            if(cur.isEmpty()){
                res.add(list);
                cur = next;
                next = new LinkedList<TreeNode>();
                list = new ArrayList<Integer>();
            }
        }
    }
}
