import java.util.HashSet;

public class Q2_1 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.randomList(10);
        list1.printList();
        list1.removeDupA();
        list1.printList();

        list1.randomList(10);
        list1.printList();
        list1.removeDupB();
        list1.printList();
        
        list1.randomList(10);
        list1.printList();
        list1.removeDupC();
        list1.printList();
    }
}

class LinkedList {
    ListNode head;
    ListNode last;

    LinkedList() {
        head = null;
        last = null;
    }

    public void insertLast(int val) {
        ListNode newnode = new ListNode(val);
        if (head == null) {
            head = newnode;
            last = head;
        } else {
            last.next = newnode;
        }
    }

    public void insertFirst(int val) {
        ListNode newnode = new ListNode(val);
        if (head == null) {
            head = newnode;
            last = head;
        } else {
            newnode.next = head;
            head = newnode;
        }
    }
    //O(n)
    public void removeDupA() {
        if (head == null || head.next == null)
            return;
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur.val))
                prev.next = cur.next;
            else {
                set.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
    }
    //O(n^2)
    public void removeDupB() {
        if (head == null || head.next == null)
            return;
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode tmp = head;
            while (tmp != cur) {
                if (tmp.val == cur.val) {
                    prev.next = cur.next;
                    cur = cur.next;
                    break;
                }
                tmp = tmp.next;
            }
            if (tmp == cur) {
                prev = cur;
                cur = cur.next;
            }
        }
    }
    //O(n^2)
    public void removeDupC() {
        if (head == null || head.next == null)
            return;
        ListNode cur = head;
        while(cur!=null){
            ListNode tmp = cur;
            while(tmp.next!=null){
                if(tmp.next.val == cur.val){
                    tmp.next = tmp.next.next;
                }else
                tmp = tmp.next;
            }
            cur = cur.next;
        }
        
    }

    public void randomList(int n) {
        head = null;
        last = null;
        for (int i = 0; i < n; i++) {
            insertFirst((int) (10 * Math.random()));
        }
    }

    public void printList() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}
