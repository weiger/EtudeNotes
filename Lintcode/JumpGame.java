public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length == 0){
            return false;
        }
        int cur = A[0];
        int max = 0;
        for(int i = 0 ; i <= cur; i++){
            max = Math.max(max, A[i] + i);
            if(max >= A.length - 1) return true;
            if(i == cur){
                cur = max;
                max = 0;
            }
        }
        return false;
    }
}
