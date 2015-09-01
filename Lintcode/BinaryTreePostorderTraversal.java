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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode last = root;
        TreeNode cur = root;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if( (node.left == null && node.right == null) || node.left == last || node.right == last){
                int val = stack.pop().val;
                res.add(val);
                last = node;
            }else{
                if(node.right != null){
                    stack.push(node.right);
                }
                if(node.left != null){
                    stack.push(node.left);
                }
            }
        }
        return res;
    }
}
