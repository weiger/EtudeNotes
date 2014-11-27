/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null)
            return head;
        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode newnode = new RandomListNode(cur.label);
            newnode.next = cur.next;
            cur.next = newnode;
            cur = cur.next.next;
        }
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode newhead = head.next;
        while(cur!=null){
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            if(cur.next==null){
                tmp.next = null;
                break;
            }
            tmp.next = cur.next.next;
            cur = cur.next;
        }
        return newhead;
    }
}
