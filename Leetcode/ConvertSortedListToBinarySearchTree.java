public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        return sortedListToBSTHelper(head, 0, len - 1);
    }

    public TreeNode sortedListToBSTHelper(ListNode head, int start, int end) {
        if(start > end)
            return null;
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(head, start, mid - 1);
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        if(head.next != null) {
            head.val = head.next.val;
            head.next = head.next.next;
        }
        root.right = sortedListToBSTHelper(head, mid + 1, end);
        return root;
    }
/*1 2 3 4 5 6
      s   f
  1 2 3 4 5 
    s f 
*/
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(cur2.next.next != null && cur2.next.next.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next.next;
        }
        TreeNode root = new TreeNode(cur1.next.val);
        root.right = sortedListToBST(cur1.next.next);
        cur1.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head.next;
        ListNode fast = head.next;
        ListNode pre = head;
        while(fast.next!=null && fast.next.next!=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        root.right = sortedListToBST(slow.next);
        pre.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
}
