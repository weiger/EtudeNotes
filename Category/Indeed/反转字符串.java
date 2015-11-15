import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public String reverse(String str){
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] arr = str.toCharArray();
        swap(arr, 0, arr.length - 1);
        HashMap<Integer, Integer> map = new HashMap<>();
        int start = -1;
        for (int i = 0 ; i < arr.length; i++) {
            if (arr[i] == ';') {
                start = i;
            }
            if (arr[i] == '&' && start != -1 ){
                map.put(start, i);
                start = -1;
            }
        }
        for (int key: map.keySet()) {
            swap(arr, key, map.get(key));
        }
        return new String(arr);
    }

    public void swap(char[] nums, int beg, int end){
        while (beg < end) {
            char tmp = nums[beg];
            nums[beg] = nums[end];
            nums[end] = tmp;
            beg++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse("123&euro;456&amp;764"));
        System.out.println(s.reverse("12345&78&amp;888"));
        System.out.println(s.reverse("1111&123;&amp;333"));
        System.out.println(s.reverse("&&&&&"));
    }
}
