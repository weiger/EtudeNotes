/*
Given an integer array, heapify it into a min-heap array.
For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
Example
Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        if(A==null || A.length==0)
            return;
        int beg = (A.length - 2)/2;
        while(beg>=0){
            sinkDown(A,beg,A.length-1);
            beg--;
        }
    }
    public void sinkDown(int[] A,int beg,int end){
        int root = beg;
        while(2*root+1<=end){
            int child = 2 * root + 1;
            if(child + 1 <= end && A[child]>A[child+1])
                child++;
            if(A[root]>A[child]){
                int tmp = A[root];
                A[root] = A[child];
                A[child] = tmp;
                root = child;
            }else
                return;
        }
    }
}
