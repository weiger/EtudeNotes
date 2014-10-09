/* Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 */ 
//Update the sum till now, if <0, update to 0, throw away all values before
public class Solution {
    public int maxSubArray(int[] A) {
        int temp = 0;
        int max = Integer.MIN_VALUE;
        for(int x:A){
            temp = temp + x;
            max = Math.max(max,temp);
            if(temp<0)
                temp = 0;
        }
        return max;
    }
}
//local test right, leetcode WA
public class Solution {
    static int max = Integer.MIN_VALUE;
    public int maxSubArray(int[] A) {
        return helper(A,0,A.length-1);
    }
    public int helper(int[] A,int left,int right){
        if(left>right)
            return Integer.MIN_VALUE;
        int mid =  left + (right-left)/2;
        int lmax = helper(A,left,mid-1);
        int rmax = helper(A,mid+1,right);
        max = Math.max(max, Math.max(lmax, rmax));
        int sum = 0,mlmax=0;
        for(int i=mid-1;i>=left;i--){
            sum+=A[i];
            mlmax = Math.max(sum, mlmax);
        }
        sum = 0; int mrmax = 0;
        for(int i=mid+1;i<=right;i++){
            sum+=A[i];
            mrmax = Math.max(sum, mrmax);
        }
        max = Math.max(max, mlmax+mrmax+A[mid]);
        return max;
    }
}
/*from wikipedia */
    public int maxSubArray(int[] A) {
        int max_so_far = A[0], max_ending_here = A[0];
        for(int i = 1; i < A.length; i++) {//recursion starts from 1.
            if(max_ending_here < 0)
                max_ending_here = A[i];
            else
                max_ending_here += A[i];
            if(max_ending_here >= max_so_far)
                max_so_far = max_ending_here;
        }
        return max_so_far;
    }
}
