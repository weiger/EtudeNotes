/* 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Basic Solution
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while(fast!=null && fast.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(slow);
        return mergeList(p1,p2);
    }
    public ListNode mergeList(ListNode p1,ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode cur1 = p1;
        ListNode cur2 = p2;
        while(cur1!=null && cur2!=null){
            if(cur1.val<=cur2.val){
                p.next = cur1;
                cur1=cur1.next;
            }else{
                p.next = cur2;
                cur2 = cur2.next;
            }
            p = p.next;
        }
        if(cur1==null)
            p.next = cur2;
        else
            p.next = cur1;
        return dummy.next;
    }
}
