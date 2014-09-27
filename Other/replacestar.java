/*
  将一个string 里的 * 换成0 或者 1 ,输出所有的结果 
*/

import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> replacestart(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)
            return res;
        helper(res, 0, s);
        return res;
    }

    public static void helper(ArrayList<String> res, int pos, String buffer) {
        if (pos == buffer.length()) {
            res.add(buffer);
            return;
        }
        char[] arr = buffer.toCharArray();
        if (arr[pos] == '*') {
            arr[pos] = '0';
            helper(res, pos + 1, new String(arr));
            arr[pos] = '1';
            helper(res, pos + 1, new String(arr));
        } else
        helper(res, pos + 1, new String(arr));
    }

    public static void main(String[] args) {
        ArrayList<String> res = replacestart("a*c*b");
        System.out.println(res);
    } 
}
