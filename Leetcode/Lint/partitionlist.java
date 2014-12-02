/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.
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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        ListNode beforestart = null;
        ListNode beforeend = null;
        ListNode afterstart = null;
        ListNode afterend = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = null;
            if(head.val<x){
                if(beforestart==null){
                    beforestart = head;
                    beforeend = head;
                }else{
                    beforeend.next = head;
                    beforeend = beforeend.next;
                }
            }else{
                if(afterstart==null){
                    afterstart = head;
                    afterend = head;
                }else{
                    afterend.next = head;
                    afterend = afterend.next;
                }
            }
            head = next;
        }
        if(beforestart==null)
            return afterstart;
        beforeend.next = afterstart;
        return beforestart;
    }
}

