/*
Sort a linked list in O(n log n) time using constant space complexity.

Example
Given 1-3->2->null, sort it to 1->2->3->null.
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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        if(head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        head = sortList(head);
        next = sortList(next);
        return merge(head,next);
    }
    public ListNode merge(ListNode a,ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(a!=null && b!=null){
            if(a.val<=b.val){
                cur.next = a;
                a = a.next;
            }else{
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if(a!=null){
            cur.next = a;
        }else if(b!=null){
            cur.next = b;
        }
        return dummy.next;
    }
}

