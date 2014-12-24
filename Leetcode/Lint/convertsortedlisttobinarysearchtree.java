/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        return helper(head,0,len - 1);
    }

    public TreeNode helper(ListNode p,int beg,int end){
        if(beg > end)
            return null;
        int mid = beg + (end - beg)/2;
        TreeNode left = helper(p,beg,mid - 1);
        TreeNode root = new TreeNode(p.val);
        root.left = left;
        if(p.next != null){
            p.val = p.next.val;
            p.next = p.next.next;
        }
        root.right = helper(p,mid + 1,end);
        return root;
    }
}

