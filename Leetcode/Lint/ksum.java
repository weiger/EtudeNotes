/*
Given n distinct positive integers, integer k (k <= n) and a number target.

Find k numbers where sum is target. Calculate how many solutions there are?

Example
Given [1,2,3,4], k=2, target=5. There are 2 solutions:

[1,4] and [2,3], return 2.
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int  kSum(int A[], int k, int target) {
    	int[][] dp = new int[k + 1][target + 1];
    	dp[0][0] = 1;
    	for (int i = 1; i <= A.length; i++) {
    	    for (int j = Math.min(i, k); j > 0; j--) {
        		for (int m = target; m >= A[i - 1]; m--) {
        		    dp[j][m] += dp[j - 1][m - A[i - 1]];
        		}
        	}
    	}
    	return dp[k][target];
    }
}

