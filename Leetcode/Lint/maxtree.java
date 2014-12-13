/*Given an integer array with no duplicates. A max tree building on this array is defined as follow:
The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree is
              6

            /    \

         5       3

       /        /   \

     2        0     1
Challenge
O(n) time complexity */

public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        
    }
}
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for(int x:A){
            TreeNode cur = new TreeNode(x);
            if(!stack.isEmpty()){
                TreeNode top = stack.peek();
                while(!stack.isEmpty() && stack.peek().val < x){
                    top = stack.pop();
                }
                if(stack.isEmpty())
                    cur.left = top;
                else{
                    cur.left = stack.peek().right;
                    stack.peek().right = cur;
                }
            }
            stack.push(cur);
        }
        while(stack.size()>1)
            stack.pop();
        return stack.pop();
    }
}



//TLE
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        return helper(A,0,A.length-1);
    }
    public TreeNode helper(int[] A,int beg,int end){
        if(beg>end)
            return null;
        if(beg==end)
            return new TreeNode(A[beg]);
        int idx = 0;
        int res = 0;
        for(int i=beg;i<=end;i++){
            if(A[i]>res){
                idx = i;
                res = A[i];
            }
        }
        TreeNode root = new TreeNode(A[idx]);
        root.left = helper(A,beg,idx-1);
        root.right = helper(A,idx+1,end);
        return root;
    }
}
