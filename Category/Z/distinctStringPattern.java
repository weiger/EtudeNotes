import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int numDistinctDP(String s1, String s2){
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        //transform s2
        for(int i = 0; i < s2.length(); i += 2){
            char c = s2.charAt(i);
            sb2.append(c);
            map.put(c, s2.charAt(i + 1) == '+'? 1: 3);
        }
        s2 = sb2.toString();
        //transform s1
        for(int i = 0; i < s1.length() - 1; i++){
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                int value = map.get(c);
                if(isValid(s1, i, value, c)){
                    sb1.append(c);
                }
            }
        }
        s1 = sb1.toString();

        //start DP
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private static boolean isValid(String s1, int i, int value, char c){
        if(i + value > s1.length() - 1) return false;
        for(int j = 1; j <= value; j++){
            if(s1.charAt(i + j) != c) return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s1 = "waeginsapnaabangpisebbasepgnccccapisdnfngaabndlrjngeuiogbbegbuoecccc";
        String s2 = "a+b+c-";
        int res = numDistinctDP(s1, s2);
        System.out.println(res);
    }
}
