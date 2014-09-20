/*
 * Given a string S and a string T, count the number of distinct subsequences of T in S.

 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

 * Here is an example:
 * S = "rabbbit", T = "rabbit"

 * Return 3. 
 */
  0 r a b b b i t
0 1 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1 1
a 0 0 1 1 1 1 1 1
b 0 0 0 1 2 3 3 3
b 0 0 0 0 1 3 3 3
i 0 0 0 0 0 0 3 3
t 0 0 0 0 0 0 0 3  
 
 
public class Solution {
    public int numDistinct(String S, String T) {
        int[][] dp = new int[T.length()+1][S.length()+1];
        
        for(int i=0;i<=T.length();i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=S.length();i++){
            dp[0][i] = 1;
        }
        
        for(int i=1;i<=T.length();i++)
            for(int j=1;j<=S.length();j++){
                if(T.charAt(i-1)==S.charAt(j-1))
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                else
                    dp[i][j] = dp[i][j-1];
            }
        return dp[T.length()][S.length()];
    }
} 
 
 
public class DistinctSubsequences {
/*
    public int numDistinct(String S, String T) {
        int[][] dp = new int[S.length() + 1][T.length() + 1];
        for(int i = 0; i < S.length(); i++)
            dp[i][0] = 1;
        for(int i = 1; i <= S.length(); i++) {
            for(int j = 1; j <= T.length(); j++) {
                dp[i][j] = dp[i - 1][j] + ((S.charAt(i - 1) == T.charAt(j - 1)) ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[S.length()][T.length()];
    }
*/
    public int numDistinct(String S, String T) {
        int[] dp = new int[T.length() + 1];
        dp[0] = 1;
        for(int i = 0; i < S.length(); i++) {
            for(int j = T.length() - 1; j >= 0; j--) {
                if(S.charAt(i) == T.charAt(j))
                    dp[j + 1] += dp[j];
            }
        }
        return dp[T.length()];
    }
}
