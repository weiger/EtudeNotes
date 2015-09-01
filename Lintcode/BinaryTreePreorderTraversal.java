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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null) return res;
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }else{
                cur = stack.pop();
                cur = cur.right;
            }
        }
        return res;
    }
}
