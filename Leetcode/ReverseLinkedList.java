/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode left;
    boolean meet;
    public ListNode reverseList(ListNode head) {
        left = head;
        meet = false;
        helper(head);
        return head;
    }
    public ListNode helper(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode right = helper(head.next);
        if (!meet) {
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
            if (left == right || left.next == right) {
                meet = true;
            }
            left = left.next;
        }
        return head;
    }
}
