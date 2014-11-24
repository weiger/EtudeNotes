/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]*/

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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(res,root);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,TreeNode root){
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        cur.offer(root);
        boolean flag = true;
        while(!cur.isEmpty()){
            TreeNode n = cur.poll();
            list.add(n.val);
            if(n.left!=null)
                next.add(n.left);
            if(n.right!=null)
                next.add(n.right);
            if(cur.isEmpty()){
                if(flag){
                    res.add(list);
                    flag = false;
                }else{
                    Collections.reverse(list);
                    res.add(list);
                    flag = true;
                }
                cur = next;
                next = new LinkedList<TreeNode>();
                list = new ArrayList<>();
            }
        }
    }
}
