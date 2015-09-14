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
        if(n <= 0) return new int[0][0];
        int[][] res = new int[n][n];
        int x = 0; int y = 0; int num = 1;
        while(n > 0){
            if(n == 1){
                res[x][y] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                System.out.println(x + " : " + y);
                res[x][y++] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                System.out.println(x + " : " + y);
                res[x++][y] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                System.out.println(x + " : " + y);
                res[x][y--] = num++;
            }
            for(int i = 0 ; i < n - 1; i++){
                System.out.println(x + " : " + y);
                res[x--][y] = num++;
            }
            n = n - 2;
            y++;x++;
        }
        return res;
    }
}
