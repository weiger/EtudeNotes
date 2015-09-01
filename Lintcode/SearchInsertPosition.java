public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A.length == 0){
            return 0;
        }
        int beg = 0; int end = A.length - 1;
        while(beg <= end){
            int mid = beg + (end - beg) / 2;
            if(A[mid] == target){
                return mid;
            }else if(A[mid] > target){
                end = mid - 1;
            }else if(A[mid] < target){
                beg = mid + 1;
            }
        }
        return beg;
    }
}
