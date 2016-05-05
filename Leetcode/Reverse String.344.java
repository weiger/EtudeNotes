public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int beg = 0;
        int end = arr.length - 1;
        while (beg < end) {
            char tmp = arr[beg];
            arr[beg] = arr[end];
            arr[end] = tmp;
            beg++;
            end--;
        }
        return new String(arr);
    }
}