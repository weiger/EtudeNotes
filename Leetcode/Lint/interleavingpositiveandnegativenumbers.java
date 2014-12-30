/*
Given an array with positive and negative integers. Re-range it to interleaving with positive and negative integers.
Note
You are not necessary to keep the original order or positive integers or negative integers.
Example
Given [-1, -2, -3, 4, 5, 6], after re-range, it will be [-1, 5, -2, 4, -3, 6] or any other legal answer.
Challenge
Do it in-place and without extra memory.
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return an integer array
     */
    public int[] rerange(int[] A) {
        int len = A.length;
        int po = 0;
        for(int x:A){
            if(x >= 0)
                po ++;
        }
        if(po >= len - po){
            for(int i = 0, j = 1; i < len && j < len;){
                if(A[i] >= 0){
                    i += 2;
                }else if(A[j] < 0){
                    j += 2;
                }else{
                    swap(A,i,j);
                }
            }
        }else{
             for(int i = 0, j = 1; i < len && j < len;){
                if(A[i] < 0){
                    i += 2;
                }else if(A[j] >= 0){
                    j += 2;
                }else{
                    swap(A,i,j);
                }
            }           
        }
        return A;
    }
    public void swap(int[] A,int a,int b){
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
}
