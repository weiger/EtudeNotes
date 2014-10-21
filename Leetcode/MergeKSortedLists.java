/*
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
public class MergeKSortLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.size() == 0)
            return null; 
        int last = lists.size() - 1;
        while(last > 0) {
            int cur = 0;
            while(cur < last) {
                lists.set(cur, mergeTwoLists(lists.get(cur++), lists.get(last--)));
                //tricky,for example:0,8;1,7;2,6;3,5;->0,4;1,3;->0,2;0,1
            }
        }
        return lists.get(0);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
/*********************************************************/
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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists.size() == 0)
			return null;
 
		//PriorityQueue is a sorted queue
		PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
				new Comparator<ListNode>() {
					public int compare(ListNode a, ListNode b) {
						if (a.val > b.val)
							return 1;
						else if(a.val == b.val)
							return 0;
						else 
							return -1;
					}
				});
 
		//add first node of each list to the queue
		for (ListNode list : lists) {
			if (list != null)
				q.offer(list);
		}
 
		ListNode head = new ListNode(0);
		ListNode prev = head;
 
		while (q.size() > 0) {
			ListNode temp = q.poll();
			prev.next = temp;
 
			//keep adding next element of each list
			if (temp.next != null)
				q.offer(temp.next);
 
			prev = prev.next;
		}
 
		return head.next;
	}
}
/**********************************************************/
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null || lists.size()==0)  
            return null;  
        return helper(lists,0,lists.size()-1);
    }
    private ListNode helper(List<ListNode> lists, int l, int r)  
    {  
        if(l<r)  
        {  
            int m = (l+r)/2;  
            return merge(helper(lists,l,m),helper(lists,m+1,r));  
        }  
        return lists.get(l);  
    }
    //uncommon merge
    private ListNode merge(ListNode l1, ListNode l2)  
    {   
        ListNode dummy = new ListNode(0);  
        dummy.next = l1;  
        ListNode cur = dummy;  
        while(l1!=null && l2!=null)  
        {  
            if(l1.val<l2.val)  
            {  
                l1 = l1.next;  
            }  
            else  
            {  
                ListNode next = l2.next;  
                cur.next = l2;  
                l2.next = l1;  
                l2 = next;  
            }  
            cur = cur.next;  
        }  
        if(l2!=null)  
            cur.next = l2;  
        return dummy.next;  
    }  
}
