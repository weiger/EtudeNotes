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
