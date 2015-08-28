//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return -1;
        double res = (double)root.val;
        TreeNode cur = root;
        while(cur != null){
            if((double)cur.val == target){
                return cur.val;
            }
            if(Math.abs((double)cur.val - target) < Math.abs(res - target)){
                res = cur.val;
            }
            if(target < cur.val){
                cur = cur.left;
            }else if(target > cur.val){
                cur = cur.right;
            }
        }
        return (int)res;
    }
}
