/*
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
You may assume each number in the sequence is unique.
*/
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return true;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for(int i = 0 ; i < preorder.length; i++){
            if(preorder[i] < min){
                return false;
            }
            while(!stack.isEmpty() && preorder[i] > stack.peek()){
                min = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0)
            return true;
        int idx = -1;
        int min = Integer.MIN_VALUE;
        for(int i = 0 ; i < preorder.length; i++){
            if(preorder[i] < min){
                return false;
            }
            while(idx >= 0 && preorder[i] > preorder[idx]){
                int val = preorder[idx--];
                min = val;
            }
            preorder[++idx] = preorder[i];
        }
        return true;
    }
}
