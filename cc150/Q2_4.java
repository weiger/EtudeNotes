public class Q2_4 {
    public static ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode beforestart = null;
        ListNode beforeend = null;
        ListNode afterstart = null;
        ListNode afterend = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = null;
            if (cur.val < x) {
                if (beforestart == null) {
                    beforestart = cur;
                    beforeend = cur;
                } else {
                    beforeend.next = cur;
                    beforeend = cur;
                }
            } else {
                if (afterstart == null) {
                    afterstart = cur;
                    afterend = cur;
                } else {
                    afterend.next = cur;
                    afterend = cur;
                }
            }
            cur = tmp;
        }
        if (beforestart == null)
            return afterstart;
        beforeend.next = afterstart;
        return beforestart;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.randomList(10);
        list.printList();

        list.head = partition(list.head, 5);
        list.printList();
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
