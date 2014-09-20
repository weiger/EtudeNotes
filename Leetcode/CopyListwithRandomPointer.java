/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode cur = head;
        while(cur!=null){
            RandomListNode newnode = new RandomListNode(cur.label);
            newnode.next = cur.next;
            cur.next = newnode;
            cur = newnode.next;
        }
        
        cur = head;
        while(cur!=null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode copy = head.next;
        RandomListNode one = head;
        RandomListNode two = head.next;
        while(one!=null){
            one.next = two.next;
            if(one.next!=null)
                two.next = one.next.next;
            one = one.next;
            two = two.next;
        }
        return copy;
    }
}
