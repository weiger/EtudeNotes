/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

Example
For example,
Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
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
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        if(head == null || head.next == null)
            return;
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        pre = slow;
        slow = slow.next;
        pre.next = null;
        ListNode second = reverse(slow);
        ListNode cur1 = head;
        ListNode cur2 = second;
        while(cur1 != null && cur2 != null){
            ListNode p = cur1.next;
            ListNode q = cur2.next;
            cur1.next = cur2;
            cur2.next = p;
            cur1 = p;
            cur2 = q;
        }
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        ListNode q = null;
        while(p != null){
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}

