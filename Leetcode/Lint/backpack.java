/*
Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack? 

Note
You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, so that the max size we can fill this backpack is 10. If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
*/

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     */
    public int backPack(int m, ArrayList<Integer> A) {
        if (m == 0 || A.size() == 0)
    	    return 0;
    	int[] dp = new int[m + 1];
    	for (int i = 1; i <= A.size(); i++) {
    	    for (int j = m; j >= 0; j--) {
    		int v = A.get(i - 1);
    		if(j<v)
    		    dp[j] = dp[j];
    		else
    		    dp[j] = Math.max(dp[j], dp[j-v]+v);
    	    }
    	}
    	return dp[m];
    }
}



//TLE
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     */
    public int backPack(int m, ArrayList<Integer> A) {
        if (m == 0 || A.size() == 0)
	        return 0;
	    int[][] dp = new int[m + 1][A.size() + 1];
    	for (int i = 1; i <= m; i++) {
    	    for (int j = 1; j <= A.size(); j++) {
    		int v = A.get(j - 1);
    		if (i < v)
    		    dp[i][j] = dp[i][j - 1];
    		else 
    		    dp[i][j] = Math.max(dp[i][j - 1], v + dp[i - v][j - 1]);
    	    }
    	}
    	return dp[m][A.size()];
    }
}
