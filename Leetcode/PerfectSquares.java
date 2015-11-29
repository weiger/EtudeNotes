public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            int tmp = Integer.MAX_VALUE;
            for(int j = 1; i - j * j >= 0; j++){
                tmp = Math.min(tmp, dp[i - j * j] + 1);
            }
            dp[i] = tmp;
        }
        return dp[n];
    }
}
