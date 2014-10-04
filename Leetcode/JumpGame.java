/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 * Each element in the array represents your maximum jump length at that position.

 * Determine if you are able to reach the last index.

 * For example:
 * A = [2,3,1,1,4], return true.

 * A = [3,2,1,0,4], return false.
 */
public class Solution {
    public boolean canJump(int[] A) {
        int lim = A[0];
        if(lim==A.length-1)
            return true;
        for(int i=0;i<=lim;i++){
            if(i+A[i]>lim)
                lim = i+ A[i];
            if(i+A[i]>=A.length-1)
                return true;
        }
        return false;
    }
}
 
 
public class JumpGame {
    public boolean canJump(int[] A) {
        int maxIndex = 0;
        for(int i = 0; i < A.length - 1; i++) {
            maxIndex = Math.max(A[i] + i, maxIndex);
            if(maxIndex == i)
                return false;
            else if(maxIndex >= A.length - 1)
                return true;
        }
        return maxIndex >= A.length - 1;
    }
}
/*****************/
public class Solution {
    public boolean canJump(int[] A) {
        int max = 0;
        for(int i=0;i<=max&&i<A.length;i++){
            if(A[i]+i>max)
                max = A[i]+i;
            if(max>=A.length-1)
                return true;
        }
        return false;
    }
}
