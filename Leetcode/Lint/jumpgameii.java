public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if(A==null || A.length==0 || A.length==1)
            return 0;
        int reach = 0;
        int max = 0;
        int res = 0;
        for(int i=0;i<=reach;i++){
            max = Math.max(max,i+A[i]);
            if(max>=A.length-1)
                return res+1;
            if(i==reach){
                reach = max;
                res++;
            }
        }
        return res;
    }
}
