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
        // write your code
        ListNode cur1 = head;
        ListNode cur2 = head;
        ArrayList<Integer> list = new ArrayList<>();
        while(n >= 1){
            if(m > 1){
                cur1 = cur1.next;
            }
            if(m <= 1){
                list.add(cur2.val);
            }
            cur2 = cur2.next;
            m--;n--;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            cur1.val = list.get(i);
            cur1 = cur1.next;
        }
        return head;
    }
}
