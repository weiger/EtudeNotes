/*
 * Sort a linked list using insertion sort.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode cur1 = head.next;
        while(cur1!=null){
            ListNode cur2 = head;
            while(cur2!=cur1 && cur2.val<cur1.val)
                cur2 = cur2.next;
            while(cur2!=cur1){
                int tmp = cur1.val;
                cur1.val = cur2.val;
                cur2.val = tmp;
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
        return head;
    }
}
 
 
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode minNode = head, minPrev = head, minNext = head, cur = head, curPrev = head;
        while(cur != null) {
            if(cur.val < minNode.val) {
                minNode = cur;
                minPrev = curPrev;
                minNext = cur.next;
            }
            curPrev = cur;
            cur = cur.next;
        }
        if(minNode == head) 
            head = head.next;
        else
            minPrev.next = minNext;
        minNode.next = insertionSortList(head);
        return minNode;
    }


    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode p = head.next, pStart = new ListNode(0), pEnd = head;
        pStart.next = head;
        while(p != null) {
            ListNode temp = pStart.next, prev = pStart;
            while(temp != p && p.val >= temp.val) {
                temp = temp.next;
                prev = prev.next;
            }
            if(temp == p)
                pEnd = p;
            else {
                pEnd.next = p.next;
                p.next = temp;
                prev.next = p;
            }
            p = pEnd.next;
        }
        head = pStart.next;
        return head;
    }

