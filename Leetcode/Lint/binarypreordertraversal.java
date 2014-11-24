public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        helper(res,root);
        return res;
    }
    public void helper(ArrayList<Integer> res,TreeNode p){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = p;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }
}
