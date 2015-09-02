public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }
        long[] dp = new long[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for(int i = 2; i < A.length; i++){
            dp[i] = Math.max(dp[i - 1], A[i] + dp[i - 2]);
        }
        return dp[A.length - 1];
    }
}

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }
        long a = A[0];
        long b = Math.max(A[0], A[1]);
        long c = 0;
        long[] dp = new long[A.length];
        for(int i = 2 ; i < A.length; i++){
            c = Math.max(A[i] + a, b);
            a = b;
            b = c;
        }
        return c;
    }
}
