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

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++){
            for (int j = 1; i + j * j <= n; j++){
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);    
            }
        }
        return dp[n];
    }
}
