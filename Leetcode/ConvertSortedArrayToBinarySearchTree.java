/*
 * Given an array where elements are sorted in ascending order, convert it to a 
 * height balanced BST.
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    public TreeNode helper(int[] nums, int beg, int end){
        if(beg > end){
            return null;
        }
        int mid = beg + (end - beg) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, beg, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;
    }
}
