public class Solution {
    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else if(i == 0){
                    dp[i][j] = grid[i][j] + dp[i][j - 1];
                }else if(j == 0){
                    dp[i][j] = grid[i][j] + dp[i - 1][j];
                }else{
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[M - 1][N - 1];
    }
}
