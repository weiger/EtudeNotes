public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(A == null || V == null || A.length == 0 || V.length == 0){
            return 0;
        }
        int[][] dp = new int[m + 1][A.length + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= A.length; j++){
                int val = V[j - 1];
                int size = A[j - 1];
                if(size > i){
                    dp[i][j] = dp[i][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - size][j - 1] + val);
                }
            }
        }
        return dp[m][A.length];
    }
}
