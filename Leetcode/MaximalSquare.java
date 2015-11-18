public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(res, dp[i][0]);
        }
        for (int i = 0; i < N; i++) {
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(res, dp[0][i]);
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
