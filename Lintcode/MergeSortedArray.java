class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(A == null || B == null){
            return;
        }
        m--; n--;
        while(n >= 0){
            if(m >= 0){
                if(A[m] <= B[n]){
                    A[m + n + 1] = B[n--];
                }else{
                    A[m + n + 1] = A[m--];
                }
            }else{
                A[n] = B[n--];
            }
        }
    }
}
