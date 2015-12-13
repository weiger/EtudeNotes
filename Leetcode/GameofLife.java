public class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int M = board.length;
        int N = board[0].length;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int count = getCount(board, i, j, M, N);
                if (count == 3 || count + board[i][j] == 3) {
                    board[i][j] ^= 2;
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    public int getCount(int[][] board, int i, int j, int m, int n){
        int res = 0;
        for (int x = Math.max(i - 1, 0); x < Math.min(i + 2, m); x++) {
            for (int y = Math.max(j - 1, 0); y < Math.min(j + 2, n); y++) {
                res += (board[x][y] & 1);
            }
        }
        return res - (board[i][j] & 1);
    }
}
