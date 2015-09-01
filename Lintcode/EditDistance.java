public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int M = word1.length();
        int N = word2.length();
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 0 ; i <= M; i++){
            for(int j = 0 ; j <= N; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 0;
                }else if(i == 0){
                    dp[i][j] = j;
                }else if(j == 0){
                    dp[i][j] = i;
                }else{
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }else{
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
        }
        return dp[M][N];
    }
}
