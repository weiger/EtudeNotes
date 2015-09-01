class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int len = A.length + B.length;
        if(len % 2 == 0){
            return ((getKth(A, B, len/2) + getKth(A, B, len / 2 + 1))) / 2.0;
        }else{
            return getKth(A, B, len / 2 + 1);
        }
    }

    public double getKth(int[] A, int[] B, int k){
        if(A.length > B.length){
            return getKth(B, A, k);
        }
        if(A.length == 0){
            return B[k - 1];
        }
        if(k == 1){
            return Math.min(A[0], B[0]);
        }
        int pa = Math.min(A.length, k / 2);
        int pb = k - pa;
        if(A[pa - 1] < B[pb - 1]){
            return getKth(Arrays.copyOfRange(A, pa, A.length), B, k - pa);
        }else if(A[pa - 1] > B[pb - 1]){
            return getKth(A, Arrays.copyOfRange(B, pb, B.length), k - pb);
        }else{
            return A[pa - 1];
        }
    }
}
