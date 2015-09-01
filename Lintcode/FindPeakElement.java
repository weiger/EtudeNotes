class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        if(A.length == 1) return 1;
        int beg = 0; 
        int end = A.length - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(mid == 0){
                if(A[mid] > A[mid + 1]){
                    return mid;
                }else{
                    beg = mid + 1;
                }
            }else if(mid == A.length - 1){
                if(A[mid] > A[mid - 1]){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else{
                if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                    return mid;
                }else{
                    if(A[mid] < A[mid - 1]){
                        end = mid - 1;
                    }else if(A[mid] < A[mid + 1]){
                        beg = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}

