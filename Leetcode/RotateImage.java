public class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][N - i - 1];
                matrix[N - j - 1][N - i - 1] = tmp;
            }
        }
        for (int j = 0; j < N ; j++) {
            for (int i = 0; i < N / 2; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] =  matrix[N - 1 - i][j];
                matrix[N - 1 - i][j] = tmp;
            }
        }
    }
}
 
public class Solution {
    // two different rotating methods.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < (n + 1) / 2; j++) {
                int top = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = top;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++) {
            for(int j = i; j <= len - 2 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}
