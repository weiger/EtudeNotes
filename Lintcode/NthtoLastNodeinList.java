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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(cur1 != null){
            if(n <= 0){
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
            n--;
        }
        return cur2;
    }
}
