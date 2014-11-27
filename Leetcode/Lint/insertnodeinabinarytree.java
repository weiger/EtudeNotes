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
        if(root==null){
            root = node;
            return root;
        }
        int v = node.val;
        TreeNode cur = root;
        TreeNode prev = root;
        while(cur!=null){
            if(cur.val==v)
                return root;
            else if(cur.val<v){
                prev = cur;
                cur = cur.right;
            }else if(cur.val>v){
                prev = cur;
                cur = cur.left;
            }
        }
        if(v<prev.val)
            prev.left = node;
        else
            prev.right = node;
        return root;
    }
}
