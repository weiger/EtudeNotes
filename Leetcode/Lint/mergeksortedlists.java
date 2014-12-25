/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size() == 0)
            return null;
        return helper(lists,0,lists.size() - 1);
    }
    public ListNode helper(List<ListNode> list,int beg,int end){
        if(beg < end){
            int mid = beg + (end - beg)/2;
            return merge(helper(list,beg,mid),helper(list,mid + 1,end));
        }
        return list.get(beg);
    }
    public ListNode merge(ListNode p1,ListNode p2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                cur.next = p1;
                p1 = p1.next;
            }else{
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        if(p1 != null){
            cur.next = p1;
        }
        if(p2 != null){
            cur.next = p2;
        }
        return dummy.next;
    }
}

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists == null || lists.size() == 0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),new comp());
        for(ListNode l:lists){
            if(l != null)
                pq.offer(l);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(pq.size() > 0){
            ListNode next = pq.poll();
            cur.next = next;
            cur = cur.next;
            if(cur.next != null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }
    class comp implements Comparator<ListNode>{
        public int compare(ListNode p1,ListNode p2){
            if(p1.val > p2.val){
                return 1;
            }else if(p1.val == p2.val){
                return 0;
            }else{
                return -1;
            }
        }
    }

};

