/*
 * Divide two integers without using multiplication, division and mod operator.
 */
//O(logn)
public class Solution {
    public int divide(int dividend, int divisor) {
    	if(dividend == Integer.MIN_VALUE && divisor == -1)
    	    return Integer.MAX_VALUE;
    	long p = Math.abs((long) dividend);
    	long q = Math.abs((long) divisor);
    	long ret = 0;
    	while (p >= q) {
    	    int counter = 0;
    	    while (p >= (q << counter)) {
    		counter++;
    	    }
    	    ret += 1 << (counter - 1);
    	    p -= q << (counter - 1);
    	}
    	if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
    	    return (int) ret;
    	} else {
    	    return (int) (-ret);
    	}
    }
}
