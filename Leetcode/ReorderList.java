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
//Cut Linkedlist by fast slow pointer,second half must be less than first half
//1-> 2-> 3-> 4-> 5  : 1-> 2-> 3 , 4-> 5 
//1-> 2-> 3-> 4-> 5 ->6  :  1-> 2-> 3,  4-> 5 ->6 
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
	    ListNode slow = head;ListNode fast = head;
	    while(fast.next!=null && fast.next.next!=null){
    		slow = slow.next;
    		fast = fast.next.next;
	    }
	    ListNode cur1 = head;
	    ListNode cur2 = reverse(slow.next);//reverse second half
	    slow.next = null;
	    //merge
	    while(cur2!=null){
    		ListNode temp1 = cur1.next;
    		ListNode temp2 = cur2.next;
    		cur1.next = cur2;
    		cur2.next = temp1;
    		cur1 = temp1;
    		cur2 = temp2;
	    }
    }
    public ListNode reverse(ListNode head){
	    if(head==null||head.next==null) return head;
	    ListNode pre = head;ListNode cur = head.next;
	    while(cur!=null){
    		ListNode temp = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = temp;
	    }
	    head.next = null;
	    return pre;
	}
}
