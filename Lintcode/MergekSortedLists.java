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
        // write your code here
        if(lists == null || lists.size() == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(10, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        for(ListNode e: lists){
            if(e != null){
                pq.offer(e);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
            
        }
        return dummy.next;
    }
}
