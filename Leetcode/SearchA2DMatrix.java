/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,

 * Consider the following matrix:

 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 */
public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target)
                i++;
            else 
                j--;
        }
        return false;
    }
//binary search
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*if(matrix.length==0 || matrix[0].length==0)
            return false;*/
        if(target<matrix[0][0])
            return false;
        int beg = 0 ;
        int end = matrix.length - 1;
        while(beg<=end){
            int mid = (beg + end)/2;
            if(matrix[mid][0]==target)
                return true;
            else if(matrix[mid][0]<target)
                beg = mid + 1;
            else if(matrix[mid][0]>target)
                end = mid - 1;
        }
        int c = end;
        beg = 0;
        end = matrix[0].length - 1; // dont be matrix[c], it may be out of boundary
        while(beg<=end){
            int mid = (beg + end)/2;
            if(matrix[c][mid]==target)
                return true;
            else if(matrix[c][mid]<target)
                beg = mid + 1;
            else if(matrix[c][mid]>target)
                end = mid - 1;
        }
        return false;
       
        
    }
}

/******************** updated 2013/12/06 *********************/

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = m * n;
        while(i < j) {
            int mid = i + (j - i) / 2;
            if(target == matrix[mid / n][mid % n])
                return true;
            else if(target > matrix[mid / n][mid % n])
                i = mid + 1;
            else
                j = mid;
        }
        return false;
    }
}
