/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner 
of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
Note : m and n will be at most 100.
*/

public class Solution {
    /**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if(m<=0 || n<=0)
            return 0;
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=n;i++){
            dp[1][i] = 1;
        }
        for(int j=1;j<=m;j++){
            dp[j][1] = 1;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}
