/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of 
distinct solutions.
 * 
 */

public class Solution {
    int res = 0;
    public int totalNQueens(int n) {
        if(n<=0)
            return 0;
        res = 0;
        int[] chess = new int[n];
        dfs(chess,0);
        return res;
    }
    public void dfs(int[] chess,int deep){
        if(deep==chess.length){
            res++;
            return;
        }
        for(int i=0;i<chess.length;i++){
            chess[deep] = i;
            if(isvalid(chess,deep)){
                dfs(chess,deep+1);
            }
        }
    }
    public boolean isvalid(int[] chess,int deep){
        for(int i=0;i<deep;i++){
            if(chess[i]==chess[deep] || Math.abs(chess[deep]-chess[i])==deep-i)
                return false;
        }
        return true;
    }
}
