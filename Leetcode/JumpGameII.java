/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 * Each element in the array represents your maximum jump length at that position.

 * Your goal is to reach the last index in the minimum number of jumps.

 * For example:
 * Given array A = [2,3,1,1,4]

 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 
 * 0 to 1, then 3 steps to the last index.)
 */

public class JumpGameII {
	public int jump(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = 0;
        for(int i = 1; i < A.length; i++) {
            for(int j = 0; j < i; j++) {
                if(j + A[j] >= i) {
                    dp[i] = dp[j] + 1;
                    break;
                }
            }
        }
        return dp[A.length - 1];        
    }

/*************************  updated 2013/11/23  ************************/

public class Solution {
    public int jump(int[] A) {
        int cnt = 0; int max = 0; int index = 0;
        for(int i = 0;i<A.length;i++){
            if(index>=A.length-1) return cnt;
            max = Math.max(max,A[i]+i);
            if(i==index){
                index = max;
                cnt++;
            }
        }
        return cnt;
    }  
}
