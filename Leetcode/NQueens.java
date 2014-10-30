/*
 * The n-queens puzzle is the problem of placing n queens on an n��n chessboard 
 * such that no two queens attack each other.



 * Given an integer n, return all distinct solutions to the n-queens puzzle.

 * Each solution contains a distinct board configuration of the n-queens' 
 * placement, where 'Q' and '.' both indicate a queen and an empty space 
 * respectively.

 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:

 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],

 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 
 */
 public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> res = new ArrayList<String[]>();
        if(n<=0)
            return res;
        int[] chess = new int[n];
        dfs(res,chess,0);
        return res;
    }
    public void dfs(List<String[]> res,int[] chess,int deep){
        if(deep==chess.length){
            store(res,chess);
            return;
        }
        for(int i=0;i<chess.length;i++){
            chess[deep] = i;
            if(isvalid(chess,deep)){
                dfs(res,chess,deep+1);
            }
        }
    }
    public void store(List<String[]> res,int[] chess){
        String[] list = new String[chess.length];
        for(int i=0;i<chess.length;i++){
            String tmp = "";
            for(int j=0;j<chess.length;j++){
                if(j==chess[i])
                    tmp+="Q";
                else
                    tmp+=".";
            }
            list[i] = tmp;
        }
        res.add(list);
    }
    public boolean isvalid(int[] chess,int deep){
        for(int i=0;i<deep;i++){
            if(chess[deep] == chess[i] || Math.abs(chess[i]-chess[deep])==deep-i)
                return false;
        }
        return true;
    }
   
}
 //Derive from N-queen 2
public class Solution {
    public List<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
    	int[] loc = new int[n];
    	helper(res,loc,0,n);
    	return res;
    }
    public static void helper(ArrayList<String[]> res,int[] loc,int cur,int n){
    	if(cur==n){
    	    store(res,loc,n);
    	    return;
    	}
    	for(int i=0;i<n;i++){
    	    loc[cur] = i;
    	    if(isValid(loc,cur))
    		helper(res,loc,cur+1,n);
    	}
    }
    private static void store(ArrayList<String[]> res, int[] loc, int n) {
    	String[] ans = new String[n];
    	for(int i=0;i<n;i++){
    	    String row = "";
    	    for(int j=0;j<n;j++){
    		if(j==loc[i]) row+="Q";
    		else row+=".";
    	    }
    	    ans[i] = row;
    	}
    	res.add(ans);
    }
    public static boolean isValid(int[] loc, int cur) {
    	for(int i=0;i<cur;i++){
    	    if(loc[i]==loc[cur] || Math.abs(loc[cur]-loc[i])==cur-i)
    		return false;
    	}
    	return true;
    }
}

 
 
public class NQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] board = new int[n];
        placeQueenOnBoard(res, 0, board);
        return res;
    }

    public void placeQueenOnBoard(ArrayList<String[]> res, int row, int[] board) {
        int n = board.length;
        if(row == n) {
            String[] s = new String[n];
            for(int i = 0; i < n; i++) {
                s[i] = "";
                for(int j = 0; j < n; j++) 
                    s[i] += (j != board[i]) ? "." : "Q";
            }
            res.add(s);
        } else {
            for(int col = 0; col < n; col++) {
                if(isSafePlace(row, col, board)) {
                    board[row] = col;
                    placeQueenOnBoard(res, row + 1, board);
                    board[row] = 0;
                }
            }
        }
    }

    public boolean isSafePlace(int row, int col, int[] board) {
        for(int i = 0; i < row; i++)
            if(board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        return true;
    }
}
