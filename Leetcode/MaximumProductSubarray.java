/*Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.*/
//keep update max,min by max * A[i],min*A[i],A[i]
public class Solution {
    public int maxProduct(int[] A) {
        if (A.length==0) return 0;
        int max = 1;
        int min = 1;
        int res = Integer.MIN_VALUE;
         
        for (int i=0;i<A.length;i++) {
            int oldmax = max;
            max = Math.max(A[i]*max,Math.max(A[i]*min,A[i]));
            min = Math.min(A[i]*oldmax,Math.min(A[i]*min,A[i]));
            res = Math.max(res,max);
        }
        return res;
    }
}
