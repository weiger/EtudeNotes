/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the 
characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while
"AEC" is not).
Example
S = "rabbbit", T = "rabbit"

Return 3.
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[0][i] =1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(T.charAt(i-1)==S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}
