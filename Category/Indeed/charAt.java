import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    private class Node {
        String substr;
        int startIndex;
        Node next;
    }

    private List<Node> nodes = new ArrayList<>();

    public void append(String s) {
        Node newnode = new Node();
        newnode.substr = s;
        if (nodes.size() > 0) {
            Node tail = nodes.get(nodes.size() - 1);
            newnode.startIndex = tail.startIndex + tail.substr.length();
        } else {
            newnode.startIndex = 0;
        }
        nodes.add(newnode);
    }

    public char charAt(int index) {
        if (index < 0) return ' ';

        int start = 0;
        int end = this.nodes.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Node midNode = this.nodes.get(mid);
            if (midNode.startIndex <= index && index < midNode.startIndex + midNode.substr.length()) {
                if (mid >= 1) {
                    Node pre = this.nodes.get(mid - 1);
                    int length_pre = pre.substr.length() + pre.startIndex;
                    return midNode.substr.charAt(index - length_pre);
                } else {
                    return midNode.substr.charAt(index);
                }
            } else if (index < midNode.startIndex) {
                end = mid - 1;
            } else if (index >= midNode.startIndex + midNode.substr.length()) {
                start = mid + 1;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution sb = new Solution();
        sb.append("0123");
        sb.append("4567");
        sb.append("89");
        sb.append("A");
        for (int i = -1; i <= 10; i++) {
            System.out.println(i + " : " + sb.charAt(i));
        }
    }
}
