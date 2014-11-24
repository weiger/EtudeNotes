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
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode p = head.next;
        head.next = null;
        while(p!=null){
            ListNode q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}

