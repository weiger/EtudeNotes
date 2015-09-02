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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        int len = 1;
        while(cur.next != null){
            cur = cur.next;
            len++;
        }
        n = len - n;
        
        cur = dummy;
        while(cur != null && n > 0){
            n--;
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
