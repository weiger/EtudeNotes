/*
 * You are given an n x n 2D matrix representing an image.

 * Rotate the image by 90 degrees (clockwise).

 * Follow up:
 * Could you do this in-place?
 */
public class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i = 0;i<matrix.length;i++)
            for(int j = 0;j<matrix[0].length-i;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-j-1][matrix[0].length-i-1];
                matrix[matrix.length-j-1][matrix[0].length-i-1] = tmp;
            }
        
        for(int i=0;i<matrix.length/2;i++)
            for(int j=0;j<matrix[0].length;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = tmp;
            }
        
    }
}
 
 
public class RotateImage {
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

/*************************** updated 2013/12/13 ******************************/

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
