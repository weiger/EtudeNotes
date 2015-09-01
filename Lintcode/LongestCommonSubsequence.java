public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int M = A.length();
        int N = B.length();
        int[][] dp = new int[M + 1][N + 1];
        for(int i = 0 ; i <= M; i++){
            for(int j = 0 ; j <= N; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[M][N];
    }
}
