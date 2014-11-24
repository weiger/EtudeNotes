/*Easy Binary Tree Inorder Traversal Show Result My Submissions

36% Accepted
Given a binary tree, return the inorder traversal of its nodes' values.

Example
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3
*/
 

return [1,3,2].

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(res,root);
        return res;
    }
    public void helper(ArrayList<Integer> res, TreeNode p){
        if(p==null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = p;
        while(p!=null || !stack.isEmpty()){
            if(p!=null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
    }
}
