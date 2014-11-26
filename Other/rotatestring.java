//"abcedf" m = 3 edfabc

public class Solution {
    // O(m+n)
    public static String rotateStr1(String str, int m) {
        if (m < 0 || m > str.length() - 1)
            return str;
        while (m > 0) {
            str = inserttoLast(str);
            m--;
        }
        return str;
    }

    public static String inserttoLast(String str) {
        if (str == null || str.length() == 0)
            return str;
        return str.substring(1) + str.charAt(0);
    }

    // O(n)
    public static String rotateStr2(String str, int m) {
        if (m < 0 || m > str.length() - 1)
            return str;
        char[] arr = str.toCharArray();
        reverse(arr, 0, m - 1);
        reverse(arr, m, str.length() - 1);
        reverse(arr, 0, str.length() - 1);
        return new String(arr);
    }

    public static void reverse(char[] arr, int beg, int end) {
        if (beg < 0 || end >= arr.length)
            return;
        while (beg < end) {
            char tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;
            beg++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println(rotateStr1("abcdef", 1));
        System.out.println(rotateStr2("abcdef", 1));
    }
}
