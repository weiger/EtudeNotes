public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        int N = matrix.length;
        for(int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - i; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - j][N - 1 - i];
                matrix[N - 1 - j][N - 1 - i] = tmp;
            }
        }
        for(int i = 0; i < N / 2; i++){
            for(int j = 0; j < N; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[N - 1 - i][j];
                matrix[N - 1 - i][j] = tmp;
            }
        }
    }
}
