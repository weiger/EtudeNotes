/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null){
            if(cur.next!=null && cur.val == cur.next.val){
                while(cur.next!=null && cur.val == cur.next.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
 
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        while(cur1.next != null) {
            ListNode cur2 = cur1.next;
            while(cur2.next != null && cur2.val == cur2.next.val) 
                cur2 = cur2.next;
            if(cur2 != cur1.next) 
                cur1.next = cur2.next;
            else 
                cur1 = cur1.next;
        }
        return dummy.next;
    }

/**************************** 2014.02.24 *************************************/

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode cur1 = head;
        ListNode cur2 = head.next;
        if (cur1.val != cur2.val) {
            cur1.next = deleteDuplicates(cur2);
            return head;
        } else {
            while (cur2 != null && cur1.val == cur2.val)
                cur2 = cur2.next;
            return deleteDuplicates(cur2);
        }
    }
}
