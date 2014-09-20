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
