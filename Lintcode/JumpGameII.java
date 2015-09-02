public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int cur = A[0];
        int count = 1;
        int max = 0;
        for(int i = 0 ; i < A.length; i++){
            max = Math.max(max, A[i] + i);
            if(cur >= A.length - 1) return count;
            if(i == cur){
                cur = max;
                count++;
            }
        }
        return count;
    }
}
