// 什么鬼！
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
