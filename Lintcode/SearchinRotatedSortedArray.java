public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int beg = 0; int end = A.length - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(A[mid] == target){
                return mid;
            }
            if(A[beg] < A[mid]){
                if(target >= A[beg] && target <= A[mid]){
                    end = mid - 1;
                }else{
                    beg = mid + 1;
                }
            }else{
                if(target >= A[mid] && target <= A[end]){
                    beg = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
