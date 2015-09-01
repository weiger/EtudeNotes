public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        int beg = 0; int end = A.length - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(A[mid] == target){
                return true;
            }
            if(A[beg] < A[mid]){
                if(target >= A[beg] && target <= A[mid]){
                    end = mid - 1;
                }else{
                    beg = mid + 1;
                }
            }else if(A[beg] > A[mid]){
                if(target >= A[mid] && target <= A[end]){
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
