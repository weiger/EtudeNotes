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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        int res = 0;
        while(l1 != null || l2 != null){
            int a = l1 == null ? 0: l1.val;
            int b = l2 == null ? 0: l2.val;
            res = (a + b + carry) % 10;
            carry = (a + b + carry) / 10;
            cur.next = new ListNode(res);
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}
