import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public String getWords(String str, int n){
        if (str == null || str.length() == 0 || n <= 0) {
            return "";
        }
        if (n >= str.length()) {
            return str;
        }
        while (n >= 0 && str.charAt(n) != ' ') {
            n--;
        }
        return str.substring(0, n + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "indeed job interview";
        System.out.println(s.getWords(str, 6));
        System.out.println(s.getWords(str, 9));
        System.out.println(s.getWords(str, 10));
        System.out.println(s.getWords(str, 100));
    }
}
