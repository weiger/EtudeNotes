/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        if(A==null || A.length==0)
            return false;
        if(A.length==1)
            return true;
        int reach = A[0];
        int max = 0;
        for(int i=0;i<=reach;i++){
            max = Math.max(max,A[i]+i);
            if(max>=A.length-1)
                return true;
            if(i==reach){
                reach = max;
            }
        }
        return false;
    }
}

