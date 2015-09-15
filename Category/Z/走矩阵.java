// 矩阵，0表示通路，1表示block.从左上角走到右下角一共有多少走法, 可以上下左右走
// Unique path2 变种， 以下方法被面试官否定，复杂度太高
public class Solution {
    int res = 0;

    public int findWay(int[][] A) {
        boolean[][] rec = new boolean[A.length][A[0].length];
        dfs(A, rec, 0, 0);
        return res;
    }

    public void dfs(int[][] A, boolean[][] rec, int x, int y) {
        if (x == A.length - 1 && y == A[0].length - 1) {
            res++;
            return;
        }
        if (A[x][y] == 1) {
            return;
        }
        rec[x][y] = true;
        if (x - 1 >= 0 && !rec[x - 1][y]) {
            dfs(A, rec, x - 1, y);
        }

        if (x + 1 < A.length && !rec[x + 1][y]) {
            dfs(A, rec, x + 1, y);
        }

        if (y - 1 >= 0 && !rec[x][y - 1]) {
            dfs(A, rec, x, y - 1);
        }

        if (y + 1 < A[0].length && !rec[x][y + 1]) {
            dfs(A, rec, x, y + 1);
        }
        rec[x][y] = false;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int res = new Solution().findWay(arr);
        System.out.println(res);
    }
}
