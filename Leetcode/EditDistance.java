/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)

 * You have the following 3 operations permitted on a word:

 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
/*dp[i][j] means how many steps from length i str to length j string
  xxxxa,yyyyb 1.a==b xxxx->yyyy
              2.a!=b (1) xxxx->yyyy + b = i-1 j-1 + 1
                     (2) xxxxa->yyyy + b = i j-1 + 1
                     (3) xxxxa del a + xxxx->yyyyb = i-1 j + 1
*/
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++) 
            dp[i][0] = i;
        for(int i = 0; i <= word2.length(); i++)
            dp[0][i] = i;
        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
