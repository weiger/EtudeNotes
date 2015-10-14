import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public int twoWayDP(int[][] A) {
        int M = A.length - 1;
        int N = A[0].length - 1;
        int[][][][] dp = new int[M + 1][N + 1][M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                for (int k = 1; k <= M; k++) {
                    for (int l = 1; l <= N; l++) {
                        if((i < M || j < N) && i <= k && j <= l){
                            continue;
                        }

                        int num = 0;
                        // 两个点都由上
                        num = Math.max(num, dp[i - 1][j][k - 1][l]);
                        // 第一个点由上，第二个点从左，并且两个来源点不重合
                        if(i - 1 != k && j != l - 1){
                            num = Math.max(num, dp[i - 1][j][k][l - 1]);
                        }
                        // 第一个点由左，第二个点从上，并且两个来源点不重合
                        if(i != k - 1 && j - 1 != l){
                            num = Math.max(num, dp[i][j - 1][k - 1][l]);
                        }
                        // 两个点都由左
                        num = Math.max(num, dp[i][j - 1][k][l - 1]);
                        // 加上当前两点
                        dp[i][j][k][l] = num + A[i][j] + A[k][l];
                    }
                }
            }
        }
        return dp[M][N][M][N];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        int[][] A = {
                {0, 0, 0, 0},
                {0, 0, 3, 9},
                {0, 2, 8, 5},
                {0, 5, 7, 0},
        };
        System.out.println(test.twoWayDP(A));
    }
}
