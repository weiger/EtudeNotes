/*
Given two strings, find the longest comment subsequence (LCS).

Your code should return the length of LCS.

Example
For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1

For "ABCD" and "EACB", the LCS is "AC", return 2
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=n;j++){
            dp[0][j] = 0;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
               if(A.charAt(i-1)==B.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1] + 1;
               }else if(dp[i][j-1]>=dp[i-1][j]){
                   dp[i][j] = dp[i][j-1];
               }else{
                   dp[i][j] = dp[i-1][j];
               }
            }
        }
        return dp[m][n];
    }
}

