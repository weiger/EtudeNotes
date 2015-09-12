/*
 * Given n non-negative integers representing an elevation map where the width 
 * of each bar is 1, compute how much water it is able to trap after raining.

 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
 public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int beg = 0;
        int end = height.length - 1;
        int lmax = 0;
        int rmax = 0;
        int sum = 0;
        while(beg <= end){
            lmax = Math.max(lmax, height[beg]);
            rmax = Math.max(rmax, height[end]);
            if(lmax < rmax){
                sum += (Math.min(lmax, rmax) - height[beg++]);
            }else{
                sum += (Math.min(lmax, rmax) - height[end--]);
            }
        }
        return sum;
    }
}
 
 
public class Solution {
    public int trap(int[] A) {
        if(A.length<3)
            return 0;
        int water = 0;
        int max = A[0];
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        left[0] = 0;
        for(int i=1;i<left.length;i++){
            left[i] = max;
            max = Math.max(max,A[i]);
        }
        right[A.length-1] = 0;
        max = A[A.length-1];
        for(int i = A.length - 2;i>=0;i--){
            right[i] = max;
            max = Math.max(max,A[i]);
            if(Math.min(right[i],left[i])>A[i])
                water+=Math.min(right[i],left[i]) - A[i];
        }
        return water;
    }
}
 
 
 
