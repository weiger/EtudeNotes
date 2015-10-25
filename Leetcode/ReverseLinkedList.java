/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p = head.next;
        head.next = null;
        ListNode q = null;
        while(p != null){
            q = p.next;
            p.next = head;
            head = p;
            p = q;
        }
        return head;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newhead = reverseList(next);
        ListNode cur = newhead;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return newhead;
    }
} 
 
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
