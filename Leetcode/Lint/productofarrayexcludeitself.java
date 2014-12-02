/*
Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B without divide operation.

Example
For A=[1, 2, 3], B is [6, 3, 2]
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        ArrayList<Long> res = new ArrayList<Long>();
        if(A==null || A.size()==0 || A.size()==1)
            return res;
        int len = A.size();
        long[] left = new long[len];
        long[] right = new long[len];
        for(int i=0;i<A.size();i++){
            if(i==0){
                left[i] = 1;
                right[len-i-1] = 1;
            }else{
                left[i] = left[i-1] * A.get(i-1);
                right[len-i-1] = right[len-i] * A.get(len-i); 
            }
        }
        for(int i=0;i<left.length;i++){
            res.add(left[i] * right[i]);
        }
        return res;
    }
}

