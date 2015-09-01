/*
Given a root of Binary Search Tree with unique value for each node.  Remove the node with given value. 
If there is no such a node with given value in the binary search tree, do nothing. You should keep the tree still
a binary search tree after removal.
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        if(root == null)
            return root;
        TreeNode cur = root;
        TreeNode pre = null;
        boolean found = false;
        while(cur != null && !found){
            if(cur.val == value){
                found = true;
            }else if(cur.val > value){
                pre = cur;
                cur = cur.left;
            }else{
                pre = cur;
                cur = cur.right;
            }
        }
        if(found){
            if(cur.left == null && cur.right == null){
                if(pre == null){
                    root = null;
                }else{
                    if(pre.left == cur){
                        pre.left = null;
                    }else if(pre.right == cur){
                        pre.right = null;
                    }
                }
            }else if(cur.left != null && cur.right == null){
                if(pre == null){
                    root = cur.left;
                }else{
                    if(pre.left == cur){
                        pre.left = cur.left;
                    }else if(pre.right == cur){
                        pre.right = cur.right;
                    }
                }
            }else if(cur.left == null && cur.right != null){
                if(pre == null){
                    root = cur.right;
                }else{
                    if(pre.left == cur){
                        pre.left = cur.right;
                    }else if(pre.right == cur){
                        pre.right = cur.right;
                    }
                }
            }else{
                if(pre == null){
                    TreeNode l = cur.left;
                    TreeNode tmp = null;
                    cur = cur.right;
                    while(cur.left != null){
                        tmp = cur;
                        cur = cur.left;
                    }
                    root.val = cur.val;
                    if(tmp == null){
                        root.right = null;
                    }else{
                        tmp.left = null;
                    }
                }else{
                    TreeNode t1 = cur;
                    TreeNode t2 = null;
                    cur = cur.right;
                    while(cur.left != null){
                        t2 = cur;
                        cur = cur.left;
                    }
                    t1.val = cur.val;
                    if(t2 != null){
                        t2.left = null;
                    }else{
                        t1.right = null;
                    }
                }
            }
            return root;
        }else
            return root;
    }
}
