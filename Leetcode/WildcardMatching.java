/*
 * Implement wildcard pattern matching with support for '?' and '*'.

 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).

 * The matching should cover the entire input string (not partial).

 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)

 * Some examples:
 * isMatch("aa","a") ? false
 * isMatch("aa","aa") ? true
 * isMatch("aaa","aa") ? false
 * isMatch("aa", "*") ? true
 * isMatch("aa", "a*") ? true
 * isMatch("ab", "?*") ? true
 * isMatch("aab", "c*a*b") ? false 
 */
 //Star for tracking last '*' and imark for last i value when '*' appeared, keep on matching until not matching
//if we dont have '*', matching failed otherwise keep going
public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int imark = -1;
        while(i<s.length()){
            if(j<p.length() && (p.charAt(j)=='?'||s.charAt(i)==p.charAt(j))){
                ++i;++j;
            }else if(j<p.length() && p.charAt(j)=='*'){
                star = j++;
                imark = i;
            }else if(star!=-1){
                i = ++imark;
                j = star + 1;
            }else
                return false;
        }
        while(j<p.length() && p.charAt(j)=='*')
            ++j;
        return j == p.length();
    }
}
 
 public class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        int count = 0;
        //only for TLE
        for(int i = 0;i<p.length();i++){
            if(p.charAt(i)!='*')
                count++;
            if(count>m)
                return false;
        }
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                else if (i != 0 && j == 0) {
                    dp[i][j] = false;
                }
                else if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j-1] && p.charAt(j-1)=='*';
                }else{
                    if(p.charAt(j-1)==s.charAt(i-1) || p.charAt(j-1)=='?'){
                        dp[i][j] = dp[i-1][j-1];
                    }else if(p.charAt(j-1)=='*'){
                        dp[i][j] = dp[i-1][j-1]||dp[i][j-1]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }
}
 
 
public class WildcardMatching {
    /* This recursion can not access the judge large for Time Limit Exceeded 
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        if(s.length() == 0)
            return p.length() == 0 || isAllStar(p);
        if((s.charAt(0) == p.charAt(0)) || p.charAt(0) == '?')
            return isMatch(s.substring(1), p.substring(1));
        if(p.charAt(0) == '*')
            return isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
        else
            return false;
    }

    public boolean isAllStar(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '*')
                return false;
        }
        return true;
    }
    */

