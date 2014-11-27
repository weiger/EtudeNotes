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
//hashmap
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
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode p = head;
        RandomListNode newhead = new RandomListNode(head.label);
        RandomListNode q = newhead;
        map.put(p,q);
        p = p.next;
        while(p!=null){
            RandomListNode tmp = new RandomListNode(p.label);
            map.put(p,tmp);
            q.next = tmp;
            q = tmp;
            p = p.next;
        }
        p = head;
        q = newhead;
        while(p!=null){
            if(p.random!=null){
                q.random = map.get(p.random);
            }else{
                q.random = null;
            }
            p = p.next;
            q = q.next;
        }
        return newhead;
    }
}
