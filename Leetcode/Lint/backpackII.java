/*
Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put into the backpack?
Note
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        if(m == 0 || A.length == 0 || V.length == 0)
            return 0;
        int[][] dp = new int[m+1][V.length + 1];
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= V.length;j++){
                int val = V[j - 1];
                int size = A[j - 1];
                if(size > i)
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-size][j-1] + val);
            }
        }
        return dp[m][V.length];
    }
}
