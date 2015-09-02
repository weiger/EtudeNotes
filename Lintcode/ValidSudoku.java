class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0){
            return false;
        }
        int n = board.length;
        boolean[][] row = new boolean[n][n];
        boolean[][] col = new boolean[n][n];
        boolean[][] blo = new boolean[n][n];
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    continue;
                }else{
                    int c = board[i][j] - '1';
                    if(row[i][c] || col[j][c] || blo[3 * (i / 3) + j / 3][c]){
                        return false;
                    }
                    row[i][c] = true;
                    col[j][c] = true;
                    blo[3 * (i / 3) + j / 3][c] = true;
                }
            }
        }
        return true;
    }
};
