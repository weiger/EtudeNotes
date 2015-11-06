public Class List {
	HashMap<Integer, ListNode> cache;
	ListNode dummyHead;
	ListNode dummyTail;
	public List() {
		dummyTail = new ListNode(-1);
		dummyHead = new ListNode(-1);
		dummyHead.next = dummyTail;
		dummyTail.prev = dummyHead;
		cache = new HashMap<Integer, ListNode>();
	}

	public void add(int v) {
		ListNode curr = new ListNode(v);
		ListNode p = dummyTail.prev;
		p.next = curr;
		curr.prev = p;
		curr.next = dummyTail;
		dummyTail.prev = curr;
		//add to cache
		cache.put(v, curr);
	}

	public void remove(int curr) {
		if (!cache.containsKey(curr)) {
			return;
		}
		ListNode node = cache.get(curr);
		//delete
		ListNode p = node.prev;
		ListNode n = node.next;
		p.next = n;
		n.prev = p;
		//delete cache
		cache.remove(curr);
	}

	public int getSize() {
		return cache.size();
	}


	public class ListNode {
		ListNode prev;
		ListNode next;
		int key;
		public ListNode(int val) {
			key = val;
			prev = null;
			next = null;
		}
	}
}
