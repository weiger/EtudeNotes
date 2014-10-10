/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 * You are given a target value to search. If found in the array return its 
 * index, otherwise return -1.

 * You may assume no duplicate exists in the array.
 */
 /*1. Search 2 in 5 6 7 8 9 1 2 3 
      A[start]>A[end], target<=A[end], A[mid]>A[end]
   2. Search 8 in 7 8 9 1 2 3 5 6
      A[start]>A[end], target>A[end],A[mid]<A[end]
 */
 public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length==0 || A==null)
            return false;
        int beg = 0;
        int end = A.length - 1;
        while(beg<=end){
            int mid  = beg + (end-beg)/2;
            if(A[mid]==target)
                return true;
            else if(A[beg]<A[mid]){
                if(A[beg]<=target && target<=A[mid])
                    end = mid - 1;
                else
                    beg = mid + 1;
            }else if(A[beg]>A[mid]){
                if(A[mid]<=target && target<=A[end])
                    beg = mid + 1;
                else
                    end = mid - 1;
            }else
                beg++; //beg++,--,end++,-- is all ok, deal with only one elements
        }
        return false;
    }
}
 
 
 
 public class Solution {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0)
	    return -1;
    	int start = 0;
    	int end = A.length - 1;
    	while (start <= end) {
    	    int mid = (start + end) / 2;
    	    if (A[mid] > target) {
    		if (A[start] > A[end] && target <= A[end] && A[mid] > A[end])
    		    start = mid + 1;
    		else
    		    end = mid - 1;
    	    } else if (A[mid] < target) {
    		if (A[start] > A[end] && target > A[end] && A[mid] < A[end])
    		    end = mid - 1;
    		else
    		    start = mid + 1;
    	    } else
		return mid;
	}
	return -1;
    }
}

 
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(A[mid] == target)
                return mid;
            else if(A[low] <= A[mid]) {
                if(A[low] <= target && target <= A[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if(A[mid] <= target && target <= A[high])
                    low = mid + 1;
                else 
                    high = mid - 1;
            }
        }
        return -1;
    }
}
