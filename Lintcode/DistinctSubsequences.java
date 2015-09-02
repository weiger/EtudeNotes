public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int M = S.length();
        int N = T.length();
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 0 ; i <= M; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(S.charAt(i - 1) == T.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[M][N];
    }
}       
