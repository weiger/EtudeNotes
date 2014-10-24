/*Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution. */

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0)
            return;
        solve(board);
    }
    public boolean solve(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char m='1';m<='9';m++){
                        if(isvalid(board,i,j,m)){
                            board[i][j] = m;
                            if(solve(board))
                                return true;
                            else
                                board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isvalid(char[][] board,int i,int j,char m){
        for(int row=0;row<9;row++){
            if(board[row][j]==m)
                return false;
        }
        for(int col=0;col<9;col++){
            if(board[i][col]==m)
                return false;
        }
        for(int row=i/3*3;row<i/3*3+3;row++){
            for(int col=j/3*3;col<j/3*3+3;col++){
                if(board[row][col]==m)
                    return false;
            }
        }
        return true;
    }
}
