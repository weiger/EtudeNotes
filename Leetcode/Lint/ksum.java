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

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */

    public int  kSum(int A[], int k, int target) {
        int len = A.length;
        int[][][] dp = new int[len + 1][k + 1][target + 1];
        for (int i = 1; i <= len; i++) {
            if (A[i - 1] <= target) {
                for (int j = i; j <= len; j++) {
                    dp[j][1][A[i - 1]] = 1;
                }
            }
        }
        for (int i = 1; i <= len; i++) {
            for (int j = Math.min(i, k); j > 1; j--) {
                for (int m = 1; m <= target; m++) {
                    dp[i][j][m] = dp[i - 1][j][m];
                    if (m - A[i - 1] >= 0) {
                        dp[i][j][m] += dp[i - 1][j - 1][m - A[i - 1]];
                    }
                }
            }
        }
        return dp[len][k][target];
    }
}



//TLE
public class Solution {
    int res = 0;
    public int kSum(int A[], int k, int target) {
    	helper(A, 0, k, target);
    	return res;
    }

    public void helper(int[] A, int beg, int k, int target) {
    	if (k < 0 || target < 0)
    	    return;
    	if (k == 0 && target == 0) {
    	    res++;
    	    return;
	    }
    	for (int i = beg; i < A.length; i++) {
    	    helper(A, i + 1, k - 1, target - A[i]);
    	}
    }
}

