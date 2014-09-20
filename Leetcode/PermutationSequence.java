/*
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):

 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.

 * Note: Given n will be between 1 and 9 inclusive.
 */

public class PermutationSequence {

/**************************** updated 2014.03.12 *****************************/

   public String getPermutation(int n, int k) {
        String res = "";
        String s = "";
        int factor = 1;
        for (int i = 1; i <= n; i++) {
            s += i;
            factor *= i;
        }
        k--;
        while (n > 0) {
            factor /= n;
            res += s.charAt(k / factor);
            s = s.substring(0, k / factor) + s.substring(k / factor + 1);
            k %= factor;
            n--;
        }
        return res;
    } 
}
/************************************************************************/
//Time Limit Exceeded
public class Solution {
    public String getPermutation(int n, int k) {
        String str = "";
    	ArrayList<String> res = new ArrayList<String>();
    	boolean[] isVistend = new boolean[n + 1];
    	helper(res, str, isVistend, 1, n, n);
    	return res.get(k-1);
    }
    public static void helper(ArrayList<String> res, String str,
	    boolean[] isVistend, int m, int n, int k) {
    	if (k == 0) {
    	    res.add(str);
    	    return;
    	}
    	for (int i = m; i <= n; i++) {
    	    if (!isVistend[i]) {
    		str = str + i;
    		isVistend[i] = true;
    		helper(res, str, isVistend, m, n, k - 1);
    		isVistend[i] = false;
    		str = str.substring(0, str.length() - 1);
    	    }
    	}
    }
}
