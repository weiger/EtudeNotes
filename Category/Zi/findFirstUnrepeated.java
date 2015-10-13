import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    Node head;
    Node tail;

    public Solution() {
        head = null;
        tail = null;
    }

    public void findFirstNonRepeating(String str){
        Node[] map = new Node[256];
        boolean[] rec = new boolean[256];
        for (int i = 0 ; i < 256; i++) {
            map[i] = null;
            rec[i] = false;
        }

        for (int i = 0 ; i < str.length(); i++) {
            System.out.println("Reading: " + str.charAt(i));
            int idx = str.charAt(i) - 'a';
            if (!rec[idx]) {
                if (map[idx] == null) {
                    addNode(str.charAt(i));
                    map[idx] = tail;
                } else {
                    deleteNode(map[idx]);
                    map[idx] = null;
                    rec[idx] = true;
                }
            }

            if (head != null) {
                System.out.println("First non-repeated: " + head.c);
            }
        }
    }

    public void addNode(char c){
        Node newnode = new Node(c);
        if (head == null) {
            head = newnode;
            tail = newnode;

        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }

    public void deleteNode(Node node){
        if (head == null) {
            return;
        }

        if (head == node) {
            head = head.next;
        }
        if (tail == node) {
            tail = tail.prev;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        test.findFirstNonRepeating("geeksforgeeksandgeeksquizfor");
    }
}
class Node{
    Node prev;
    Node next;
    char c;
    Node(char c){
        this.c = c;
    }
}
