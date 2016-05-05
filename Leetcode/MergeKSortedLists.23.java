/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(1, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;           
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (ListNode e: lists) {
            if (e != null) {
                pq.offer(e);
            }
        }
        while (pq.size() != 0) {
            ListNode node = pq.poll();
            cur.next = node;
            if (node.next != null) {
                pq.offer(node.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    public ListNode helper(ListNode[] lists, int L, int R) {
        if (L < R) {
            int M = L + (R - L) / 2;
            return merge(helper(lists, L, M), helper(lists, M + 1, R));
        }
        return lists[L];
    }
    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        }
        if (b != null) {
            cur.next = b;   
        }
        return dummy.next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int end = lists.length - 1;
        while(end > 0) {
            int beg = 0;
            while(beg < end) {
                lists[beg] = merge(lists[beg++], lists[end--]);
            }
        }
        return lists[0];
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        if (a != null) {
            cur.next = a;
        }
        if (b != null) {
            cur.next = b;   
        }
        return dummy.next;
    }
}
