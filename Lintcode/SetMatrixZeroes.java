public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return;
        }
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){
                if(row[i] || col[j]){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
