/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Write a function to determine if a given target is in the array.
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0)
            return false;
        int beg = 0;
        int end = A.length - 1;
        while(beg <=end){
            int mid = beg + (end - beg)/2;
            if(A[mid] == target)
                return true;
            if(A[beg] < A[mid]){
                if(A[beg] <= target && target <= A[mid]){
                    end = mid - 1;
                }else{
                    beg = mid + 1;
                }
            }else if(A[beg] > A[mid]){
                if(A[mid] <= target && target <= A[end]){
                    beg = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else{
                beg++;
            }
        }
        return false;
    }
}


