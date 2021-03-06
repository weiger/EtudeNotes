/*
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
/*  public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] blocks = new boolean[9][9];
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                int c = board[i][j] - '1';
                if(rows[i][c] || cols[j][c] || blocks[i - i % 3 + j / 3][c])
                    return false;
                rows[i][c] = cols[j][c] = blocks[i - i % 3 + j / 3][c] = true;
            }
        }
        return true;
    }
*/

    public boolean isValidSudoku(char[][] board) {
        int row;
        int[] col = new int[9];
        int[] block = new int[9];
        for(int i = 0; i < 9; i++) {
            row = 0;
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.')
                    continue;
                int bit = 1 << (board[i][j] - '1');
                if((row & bit) != 0 || (col[j] & bit) != 0 || (block[i / 3 * 3 + j / 3] & bit) != 0)
                    return false;
                row |= bit;
                col[j] |= bit;
                block[i / 3 * 3 + j / 3] |= bit;
            }
        }
        return true;
    }
}
//
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length!=9 ||board[0].length!=9) return false;
        ArrayList<boolean[]> row = new ArrayList<boolean[]>();
        ArrayList<boolean[]> col = new ArrayList<boolean[]>();
        ArrayList<boolean[]> block = new ArrayList<boolean[]>();
        for(int i=0;i<9;i++){
            row.add(new boolean[9]);
            col.add(new boolean[9]);
            block.add(new boolean[9]);
        }
        
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;
                int c = board[i][j]-'1';
                if(row.get(i)[c]==true || col.get(j)[c]==true || block.get(i/3*3 + j/3)[c]==true)
                    return false;
                else{
                    row.get(i)[c] = true;
                    col.get(j)[c] = true;
                    block.get(i/3*3 + j/3)[c]=true;
                }
            }
        return true;
    }
}
