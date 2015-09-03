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
        if(preorder == null || preorder.length == 0){
            return true;
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    public boolean helper(int[] preorder, int beg, int end){
        if(beg >= end) return true;
        int pivot = preorder[beg];
        int bigger = -1;
        for(int i = beg + 1; i <= end; i++){
            if(bigger == -1 && preorder[i] > pivot) bigger = i;
            if(bigger != -1 && preorder[i] < pivot) return false;
        }
        if(bigger == -1) return helper(preorder, beg + 1, end);
        else return helper(preorder, beg + 1, bigger - 1) && helper(preorder, bigger, end);
    }
}
