/*
 * Given a linked list, remove the nth node from the end of list and return its head.

 * For example,

 *    Given linked list: 1->2->3->4->5, and n = 2.

 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        int i = 0;
        while(cur2.next!=null){
            cur2 = cur2.next;
            if(i>=n)
                cur1 = cur1.next;
            i++;
        }
        cur1.next = cur1.next.next;
        return dummy.next;
    }
}
 
 
 public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for(int i=0;fast!=null;fast=fast.next,i++){
            if(i>n)
                slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
 
 
 
 
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy, cur2 = dummy;
        for(int i = 0; cur2.next != null; i++, cur2 = cur2.next) {
            if(i >= n)
                cur1 = cur1.next;
        }
        cur1.next = cur1.next.next;
        return dummy.next;
    }
}
