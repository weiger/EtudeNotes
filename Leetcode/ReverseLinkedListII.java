/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode cur1 = head;
        ListNode cur2 = head;
        List<Integer> list = new ArrayList<>();
        while(n >= 1){
            if(m > 1){
                cur2 = cur2.next;
            }
            if(m <= 1){
                list.add(cur1.val);
            }
            cur1 = cur1.next;
            m--;n--;
        }
        for(int i = list.size() - 1; i >= 0; i--){
            cur2.val = list.get(i);
            cur2 = cur2.next;
        }
        return head;
    }
}
