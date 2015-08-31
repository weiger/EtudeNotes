public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        int N = A.size();
        long[] left = new long[N];
        left[0] = 1;
        for(int i = 1; i < N; i++){
            left[i] = A.get(i - 1) * left[i - 1];
        }
        long[] right = new long[N];
        right[N - 1] = 1;
        for(int i = N - 2; i >= 0; i--){
            right[i] = A.get(i + 1) * right[i + 1];
        }
        ArrayList<Long> res = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            res.add(left[i] * right[i]);
        }
        return res;
    }
}
