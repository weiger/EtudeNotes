/*
Reverse a linked list from position m to n.

Note
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.

Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
*/

/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if(head==null)
            return null;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode cur = head;
        ListNode back = null;
        while(n>0){
            if(m<=1){
                if(back==null)
                    back = cur;
                list.add(cur.val);
            }
            m--;n--;
            cur = cur.next;
        }
        for(int i=list.size()-1;i>=0;i--){
            back.val = list.get(i);
            back = back.next;
        }
        return head;
    }
}
