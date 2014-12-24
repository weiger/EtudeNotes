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
        int[][] dp = new int[A.length()+1][B.length()+1];
        dp[0][0] = 0;
        for(int i = 1; i <= A.length(); i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i <= B.length(); i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i <= A.length(); i++){
            for(int j = 1; j <= B.length(); j++){
                if(A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1],Math.max(dp[i - 1][j],dp[i][j - 1]));
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}


