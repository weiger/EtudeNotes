/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
Credits:
Special thanks to @stellari for adding this problem and creating all test cases.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        int len1 = 1;
        int len2 = 1;
        while(cur1.next!=null){
            cur1 = cur1.next;
            len1++;
        }
        while(cur2.next!=null){
            cur2 = cur2.next;
            len2++;
        }
        cur1 = headA;
        cur2 = headB;
        if(len1>len2){
            int dif = len1 - len2;
            while(dif>0){
                cur1 = cur1.next;
                dif--;
            }
        }else if(len1<len2){
            int dif = len2- len1;
            while(dif>0){
                cur2 = cur2.next;
                dif--;
            }
        }

        while(cur1!=null && cur2!=null){
            if(cur1.val==cur2.val)
                return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while(cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
            if(cur1 == cur2)
                return cur1;
            if(cur1 == null)
                cur1 = headB;
            if(cur2 == null)
                cur2 = headA;
        }
        return cur1;
    }
}


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        while (true) {
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            cur2 = cur2.next;
            if (cur1 == cur2) return cur1;
            if (cur1 == null) cur1 = headB;
            if (cur2 == null) cur2 = headA;
            if (cur1 == cur2) return cur1;
        }
    }
}
