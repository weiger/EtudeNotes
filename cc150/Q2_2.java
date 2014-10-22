import java.util.HashSet;

public class Q2_2 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.randomList(10);
        list1.printList();
        
        LinkedList list2 = new LinkedList();
        list2.randomList(10);
        list2.printList();
        
        LinkedList list3 = new LinkedList();
        list3.randomList(10);
        list3.printList();
        
        ListNode node1 = list1.getLastKth1(1);
        ListNode node2 = list2.getLastKth2(2);
        
        System.out.println(node1.val);
        System.out.println(node2.val);
        list3.getLastKth3(list3.head,3);

        
        
    }

}

class LinkedList {
    ListNode head;
    ListNode last;

    LinkedList() {
        head = null;
        last = null;
    }
    public ListNode getLastKth1(int k){
        if(head==null || k<=0)
            return null;
        int len = 0;
        ListNode cur = head;
        while(cur!=null){
            len++;
            cur = cur.next;
        }
        if(k>len)
            return null;
        
        cur = head;
        ListNode runner = head;
        while(k>0){
            runner = runner.next;
            k--;
        }
        while(runner!=null){
            cur = cur.next;
            runner = runner.next;
        }
        return cur;
    }
    public ListNode getLastKth2(int k){
        if(head==null || k<=0)
            return null;
        ListNode cur1 = head;
        ListNode cur2 = head;
        while(k>0){
            if(cur2==null)
                return null;
            cur2 = cur2.next;
            k--;
            
        }
        while(cur2!=null){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    public static int getLastKth3(ListNode head,int k){
        if(head==null || k==0)
            return 0;
        int n = 1 + getLastKth3(head.next,k);
        if(n==k){
            System.out.println(head.val);
        }
        return n;
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
