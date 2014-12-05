/*
Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
Example
For n=4, there are 2 distinct solutions.
*/
class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    int res = 0;
    public int totalNQueens(int n) {
        if(n<=0)
            return 0;
        int[] chess = new int[n];
        helper(chess,n,0);
        return res;
    }
    public void helper(int[] chess,int n,int deep){
        if(deep==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            chess[deep] = i;
            if(isValid(chess,deep)){
                helper(chess,n,deep+1);
            }
        }
    }
    public boolean isValid(int[] chess,int cur){
        for(int i=0;i<cur;i++){
            if(chess[i]==chess[cur] || Math.abs(chess[i]-chess[cur])==cur-i)
                return false;
        }
        return true;
    }
};


