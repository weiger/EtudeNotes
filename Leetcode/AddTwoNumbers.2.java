public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int a = 0; int b = 0; int car = 0;
        while (l1 != null || l2 != null) {
            a = 0; b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode((a + b + car) % 10);
            car = (a + b + car) / 10;
            cur = cur.next;
        }
        if (car == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}