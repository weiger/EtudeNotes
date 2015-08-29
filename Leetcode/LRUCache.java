public class LRUCache {
    Map<Integer, Node> map;
    int len;
    int capacity;
    Node head;
    Node end;
    public LRUCache(int capacity) {
        head = null;
        end = null;
        map = new HashMap<Integer, Node>();
        this.len = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            int val = curNode.value;
            deleteNode(curNode);
            setHead(curNode);
            return val;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node curNode = map.get(key);
            curNode.value = value;
            deleteNode(curNode);
            setHead(curNode);
        }else{
            Node newNode = new Node(key, value);
            if(len == capacity){
                map.remove(end.key);
                deleteNode(end);
                setHead(newNode);
                map.put(key, newNode);
            }else{
                setHead(newNode);
                map.put(newNode.key, newNode);
                len++;
            }
        }
    }

    public void setHead(Node node){
        if(head != null){
            node.next = head;
            node.pre = null;
            head.pre = node;
            head = node;
        }else{
            node.pre = null;
            node.next = null;
            head = node;
            end = node;
        }
    }

    public void deleteNode(Node node){
        Node pre = node.pre;
        Node post = node.next;
        if(pre != null){
            if(post != null){
                post.pre = pre;
                pre.next = post;
            }else{
                pre.next = null;
                end = pre;
            }
        }else{
            if(post != null){
                post.pre = null;
                head = post;
            }else{
                head = null;
                end = null;
            }
        }
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node pre;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        next = null;
        pre = null;
    }
}

//cheating method
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(16, 0.75f, true);
        this.capacity = capacity;
    }
    //重写父类get，为null时范围-1
    public Integer get(Object key) {
        Integer v = super.get(key);
        if (v != null)
            return v;
        else
            return -1;
    }
    //重写父类方法，当超过缓存容量时，就删除最老的
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public void set(int key, int value) {
        super.put(key, value);
    }
}
//from programcreek
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, Integer> {
    HashMap<Integer,DoubleLinkedListNode> map;
    DoubleLinkedListNode head;
    DoubleLinkedListNode end;
    int len;
    int capacity;
    public LRUCache(int capacity) {
        head = null;
        end = null;
        this.len = 0;
        this.capacity = capacity;
        map = new HashMap<Integer,DoubleLinkedListNode>();
    }
    public Integer get(Object key) {
        if(map.containsKey(key)){
            DoubleLinkedListNode latest = map.get(key);
            deleteNode(latest);
            setHead(latest);
            return latest.value;
        }else
            return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            DoubleLinkedListNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            setHead(node);
        }else{
            DoubleLinkedListNode newnode = new DoubleLinkedListNode(key,value);
            if(len<capacity){
                setHead(newnode);
                map.put(key,newnode);
                len++;
            }else{
                map.remove(end.key);
                deleteNode(end);
                setHead(newnode);
                map.put(key, newnode);
            }
        }
    }
    public void setHead(DoubleLinkedListNode cur){
        cur.next = head;
        cur.pre = null;
        if(head==null)
            end = cur;
        else{
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
    DoubleLinkedListNode next;
    DoubleLinkedListNode pre;
    DoubleLinkedListNode(int key,int value){
        next = null;
        pre = null;
        this.key = key;
        this.value = value;
    }   
}
