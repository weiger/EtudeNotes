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
        // write your code here
        if(head == null){
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode copyhead = new RandomListNode(head.label);
        map.put(head, copyhead);
        RandomListNode cur1 = head;
        cur1 = cur1.next;
        RandomListNode cur2 = copyhead;
        while(cur1 != null){
            RandomListNode newnode = new RandomListNode(cur1.label);
            map.put(cur1, newnode);
            cur2.next = newnode;
            cur2 = cur2.next;
            cur1 = cur1.next;
        }
        cur1 = head;
        while(cur1 != null){
            if(cur1.random != null){
                map.get(cur1).random = map.get(cur1.random);
            }
            cur1 = cur1.next;
        }
        return copyhead;
    }
}
