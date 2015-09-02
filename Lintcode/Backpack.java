public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if(A == null || A.length == 0) return 0;
        int[] dp = new int[m + 1];
        for(int i = 0 ; i < A.length; i++){
            for(int j = m; j >= 0; j--){
                if(j - A[i] >= 0){
                    dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
                }
            }
        }
        return dp[m];
    }
}
