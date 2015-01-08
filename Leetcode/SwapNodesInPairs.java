/*
 * Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 */
 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode n1 = head;
        ListNode n2 = head.next;
        while(n1 != null){
            cur.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            cur = cur.next.next;
            n1 = n1.next;
            if(n1 == null || n1.next == null)
                break;
            n2 = n1.next;
        }
        return dummy.next;
    }
}
 
 
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode root = head.next;
        head.next = swapPairs(head.next.next);
        root.next = head;
        return root;
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode root = new ListNode(0);
        ListNode cur1 = head, cur2 = head.next, cur = root;
        while(cur2 != null) {
            cur.next = cur2;
            cur1.next = cur2.next;
            cur2.next = cur1;
            cur = cur1;
            if(cur1.next == null)
                break;
            cur1 = cur1.next;
            cur2 = cur1.next;
        }
        return root.next;
    }
}
