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
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        int i = 0;
        while (cur1.next != null) {
            cur1 = cur1.next;
            i++;
            if (i > n) {
                cur2 = cur2.next;
            }
        }
        cur2.next = cur2.next.next;
        return dummy.next;
    }
}
