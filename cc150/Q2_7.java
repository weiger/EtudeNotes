import java.util.Stack;

public class Q2_4 {
    
    public static boolean isPalindrome(ListNode head){
        if(head==null || head.next==null)
            return true;
        Stack<Integer> stack = new Stack<Integer>();
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;
        while(slow!=null){
            int a = stack.pop();
            if(slow.val!=a)
                return false;
            slow = slow.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(5);
        list.insertFirst(3);
        list.insertFirst(1);
        list.insertFirst(3);
        list.insertFirst(5);
        System.out.println(isPalindrome(list.head));
        
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
