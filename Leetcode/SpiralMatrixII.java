/*
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 * For example,
 * Given n = 3,

 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ] 
 */
 //Same as Spiral Matrix I
 public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int value = 1;
        int len = n;
        int x = 0;
        int y = 0;
        while(len>0){
            if(len==1){
                res[x][y] = value;
                return res;
            }
            for(int i=0;i<len-1;i++){
                res[x][y++] = value++;
            }
            for(int i=0;i<len-1;i++){
                res[x++][y] = value++;
            }
            for(int i=0;i<len-1;i++){
                res[x][y--] = value++;
            }
            for(int i=0;i<len-1;i++){
                res[x--][y] = value++;
            }
            x++;
            y++;
            len -=2;
        }
        return res;
    }
}
 
 
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int value = 1;
        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = i; j < n - i; j++) {
                result[i][j] = value++;
            }
            for(int j = i + 1; j < n - i; j++) {
                result[j][n - 1 - i] = value++;
            }
            for(int j = n - 2 - i; j >= i; j--) {
                result[n - 1 - i][j] = value++;
            }
            for(int j = n - 2 - i; j > i; j--) {
                result[j][i] = value++;
            }
        }
        return result;
    }
}
