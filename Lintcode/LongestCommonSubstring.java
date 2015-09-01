public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int M = A.length();
        int N = B.length();
        int[][] dp = new int[M + 1][N + 1];
        int max = 0;
        for(int i = 0; i <= M; i++){
            for(int j = 0 ; j <= N; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(A.charAt(i - 1) == B.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
