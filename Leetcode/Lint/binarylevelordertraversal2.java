/*
Example
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(res,root);
        Collections.reverse(res);
        return res;
    }
    public void helper(ArrayList<ArrayList<Integer>> res,TreeNode p){
        Queue<TreeNode> cur = new LinkedList<TreeNode>();
        Queue<TreeNode> next = new LinkedList<TreeNode>(); 
        ArrayList<Integer> list = new ArrayList<Integer>();
        cur.offer(p);
        while(!cur.isEmpty()){
            TreeNode n = cur.poll();
            list.add(n.val);
            if(n.left!=null)
                next.offer(n.left);
            if(n.right!=null)
                next.offer(n.right);
            if(cur.isEmpty()){
                cur = next;
                res.add(list);
                next = new LinkedList<TreeNode>();
                list = new ArrayList<Integer>();
            }    
        }
    }
}
