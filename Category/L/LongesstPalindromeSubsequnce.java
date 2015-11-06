public class Solution {
    public static int maxLengthPalindrome(int[] values) {
        return helper2(values);
    }

    public static int helper1(int[] A, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (A[i] == A[j] && i + 1 == j) {
            return 2;
        }
        if (A[i] == A[j]) {
            return helper1(A, i + 1, j - 1) + 2;
        }

        return Math.max(helper1(A, i, j - 1), helper1(A, i + 1, j));
    }

    public static int helper2(int[] A) {
        int len = A.length;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int N = 2; N <= len; N++) {
            for (int i = 0; i < len - N + 1; i++) {
                int j = i + N - 1;
                if (A[i] == A[j] && N == 2) {
                    dp[i][j] = 2;
                } else if (A[i] == A[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 2, 3, 4, 5, 6, 5, 4, 3, 4, 4, 4, 4, 4, 4, 4};
        System.out.println(maxLengthPalindrome(A));
    }
}
