public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || word == null || board.length == 0){
            return false;
        }
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0 ; j < board[0].length; j++){
                if(dfs(board, i, j, word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word){
        if(word.length() == 0){
            return true;
        }
        boolean b1 = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        if(word.charAt(0) == board[i][j]){
            char tmp = board[i][j];
            board[i][j] = '.';
            if(i - 1 >= 0) b1 = dfs(board, i - 1, j, word.substring(1));
            if(!b1 && i + 1 < board.length) b2 = dfs(board, i + 1, j, word.substring(1));
            if(!b1 && !b2 && j - 1 >= 0) b3 = dfs(board, i, j - 1, word.substring(1));
            if(!b1 && !b2 && !b3 && j + 1 < board[0].length) b4 = dfs(board, i, j + 1, word.substring(1));
            if(b1 || b2 || b3 || b4){
                return true;
            }
            board[i][j] = tmp;
        }
        return false;
    }
}
