/*
Given two strings, find the longest common substring.
Return the length of it.
Note
The characters in substring should occur continiously in original string. This is different with subsequnce
*/

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
