/*
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",

 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 */
 
public boolean isInterleave(String s1, String s2, String s3) {
    if(s1.length()+s2.length()!=s3.length())
        return false;
    String minWord = s1.length()>s2.length()?s2:s1;
    String maxWord = s1.length()>s2.length()?s1:s2;
    boolean[] res = new boolean[minWord.length()+1];
    res[0] = true;
    for(int i=0;i<minWord.length();i++)
    {
        res[i+1] = res[i] && minWord.charAt(i)==s3.charAt(i);
    }
    for(int i=0;i<maxWord.length();i++)
    {
        res[0] = res[0] && maxWord.charAt(i)==s3.charAt(i);
        for(int j=0;j<minWord.length();j++)
        {
            res[j+1] = res[j+1]&&maxWord.charAt(i)==s3.charAt(i+j+1) || res[j]&&minWord.charAt(j)==s3.charAt(i+j+1);
        }
    }
    return res[minWord.length()];
}
 
//dp[i][j] means string s1 with length i and string s2 with length j can be interleave to i+j length string
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++) 
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        for(int i = 1; i <= s2.length(); i++)
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) 
                    || dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
