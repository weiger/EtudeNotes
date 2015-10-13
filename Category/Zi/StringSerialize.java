import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public static String serialize(List<String> words) {
        StringBuffer sb = new StringBuffer();
        for (String s : words) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static List<String> deserialize(String s) {
        List<String> list = new ArrayList<String>();
        char[] s1 = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : s1) {
            if (c != ' ') {
                sb.append(c);
            } else {
                list.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        list.add(sb.toString());
        return list;
    }

    public static void main(String[] args) {
        List<String> list = deserialize("dsfds fdsfdsf yutyu ewrewrewr");
        System.out.println(list);
        String s1 = serialize(list);
        System.out.println(s1);
    }
}
