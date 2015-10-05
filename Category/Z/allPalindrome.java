import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static List<String> allPalindrome(String s){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            List<String> list1 = expand(s, i, i);
            res.addAll(list1);
            if(i >= 1){
                List<String> list2 = expand(s, i - 1, i);
                res.addAll(list2);
            }
        }
        return res;
    }
    
    public List<String> findAllPalindrome(String str) {
        HashSet<String> set = new HashSet<>();
        if (str == null || str.length() == 0 ) return res;
        int len = str.length();
        boolean[][] rec = new boolean[len][len];
        for (int i = 0 ; i < str.length(); i++) {
            for (int j = 0 ; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j <= 1 || rec[j + 1][i - 1])) {
                    rec[i][j] = true;
                    set.add(str.substring(j, i + 1));
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<String> expand(String s, int beg, int end){
        List<String> list = new ArrayList<>();
        while(beg >= 0 && end < s.length()){
            if(s.charAt(beg) == s.charAt(end)){
                list.add(s.substring(beg, end + 1));
                beg--;
                end++;
            }else{
                return list;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "bobs";
        List<String> list = allPalindrome(s);
        System.out.println(list);
    }
}
