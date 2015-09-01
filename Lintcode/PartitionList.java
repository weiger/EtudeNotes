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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode cur = head;
        ListNode beforehead = null;
        ListNode beforetail = null;
        ListNode afterhead = null;
        ListNode aftertail = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = null;
            if(cur.val < x){
                if(beforehead == null){
                    beforehead = cur;
                    beforetail = cur;
                }else{
                    beforetail.next = cur;
                    beforetail = cur;
                }
            }else{
                if(afterhead == null){
                    afterhead = cur;
                    aftertail = cur;
                }else{
                    aftertail.next = cur;
                    aftertail = cur;
                }
            }
            cur = next;
        }
        if(beforehead == null){
            return afterhead;
        }else{
            beforetail.next = afterhead;
            return beforehead;
        }
    }
}
