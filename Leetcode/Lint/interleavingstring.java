/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
Example
For s1 = "aabcc" s2 = "dbbca"
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false
*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null || s2==null || s3==null || s1.length()+s2.length()!=s3.length())
            return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for(int i=1;i<=s1.length();i++){
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1)==s3.charAt(i-1));
        }
        for(int j=1;j<=s2.length();j++){
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1)==s3.charAt(j-1));
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                dp[i][j] = (dp[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1))||
                    (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
