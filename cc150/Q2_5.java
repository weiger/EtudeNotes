public class Q2_4 {
  
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        list1.randomList(10);
        list2.randomList(10);
        list1.printList();
        list2.printList();
        
        LinkedList list3 = new LinkedList();
        list3.head = list3.addTwoList(list1.head, list2.head);
        list3.printList();
    }

}

class LinkedList {
    ListNode head;
    ListNode last;
    public ListNode addTwoList(ListNode l1,ListNode l2){
        if(l1==null && l2==null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int ca = 0;
        int cb = 0;
        int cin = 0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                ca = l1.val;
                l1 = l1.next;
            }
            else
                ca = 0;
            
            if(l2!=null){
                cb = l2.val;
                l2 = l2.next;
            }
            else
                cb = 0;
            cur.next = new ListNode((ca+cb+cin)%10);
            cin = (ca+cb+cin)/10;
            cur = cur.next;
        }
        if(cin==1)
            cur.next = new ListNode(1);
        return dummy.next;
    }
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
