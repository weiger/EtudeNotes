/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: 
get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
it should invalidate the least recently used item before inserting a new item.
*/

public class Solution {
    HashMap<Integer,DoubleLinkedListNode> map;
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    int len;
    int capacity;
    // @param capacity, an integer
    public Solution(int capacity) {
        head = null;
        end = null;
        this.len = 0;
        this.capacity = capacity;
        map = new HashMap<Integer,DoubleLinkedListNode>();
    }

    // @return an integer
    public int get(int key) {
        if(map.containsKey(key)){
            DoubleLinkedListNode latest = map.get(key);
            deleteNode(latest);
            setHead(latest);
            return latest.value;
        }else
            return -1;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedListNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            setHead(node);
        }else{
            DoubleLinkedListNode node = new DoubleLinkedListNode(key,value);
            if(len < capacity){
                setHead(node);
                len ++;
                map.put(key,node);
            }else{
                map.remove(end.key);
                deleteNode(end);
                setHead(node);
                map.put(key,node);
            }
        }
    }
    public void setHead(DoubleLinkedListNode cur){
        cur.next = head;
        cur.pre = null;
        if(head == null){
            end = cur;
        }else{
            head.pre = cur;
        }
        head = cur;
    }
    public void deleteNode(DoubleLinkedListNode node){
        DoubleLinkedListNode pre = node.pre;
        DoubleLinkedListNode post = node.next;
        if (pre != null) {
            pre.next = post;
        } else {
            head = post;
        }

        if (post != null) {
            post.pre = pre;
        } else {
            end = pre;
        }
    }
}

class DoubleLinkedListNode{
    int key;
    int value;
    DoubleLinkedListNode pre;
    DoubleLinkedListNode next;
    DoubleLinkedListNode(int key,int value){
        pre = null;
        next = null;
        this.key = key;
        this.value = value;
    }
}
