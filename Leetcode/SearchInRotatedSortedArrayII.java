/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?

 * Would this affect the run-time complexity? How and why?

 * Write a function to determine if a given target is in the array. 
 */
//It works on both I&II
public class Solution {
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0) return false;
        int start = 0 ;
        int end = A.length-1;
        while(start<=end){
            int mid = (start + end)/2;
            if(A[mid]==target) return true;
            if(A[start]<A[mid]){
                if(A[start]<=target && target<=A[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }else if(A[start]>A[mid]){
                if(A[mid]<=target && target<=A[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }else
                start++;
        }
        return false;
    }
}
//from upper part
public class Solution {
    public boolean search(int[] A, int target) {
        if(A==null || A.length==0)
            return false;
        int beg = 0;
        int end = A.length - 1;
        while(beg<=end){
            int mid = (beg + end)/2;
            if(A[mid] == target)
                return true;
            else if(A[mid]<A[end]){
                if(A[mid]<=target && target<=A[end])
                    beg = mid + 1;
                else
                    end = mid - 1;
            }else if(A[mid]>A[end]){
                if(A[beg]<=target && target<=A[mid])
                    end = mid - 1;
                else
                    beg = mid + 1;
            }else
                end--;
        }
        return false;
    }
}
