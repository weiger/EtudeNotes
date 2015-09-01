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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null){
            root = node;
            return root;
        }
        TreeNode cur = root;
        TreeNode pre = root;
        while(cur != null){
            pre = cur;
            if(node.val < cur.val){
                cur = cur.left;
            }else if(node.val > cur.val){
                cur = cur.right;
            }else{
                return root;
            }
        }
        if(pre.val > node.val){
            pre.left = node;
        }else{
            pre.right = node;
        }
        return root;
    }
}
