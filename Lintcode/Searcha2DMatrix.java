public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || target < matrix[0][0]){
            return false;
        }
        int beg = 0;
        int end = matrix.length - 1;
        while (beg <= end){
            int mid = beg + (end - beg) / 2;
            if (matrix[mid][0] == target){
                return true;
            } else if (matrix[mid][0] > target){
                end = mid - 1;
            } else if (matrix[mid][0] < target){
                beg = mid + 1;
            }
        }
        int row = end;
        beg = 0;
        end = matrix[0].length - 1;
        while (beg <= end){
            int mid = beg + (end - beg) / 2;
            if (matrix[row][mid] == target){
                return true;
            } else if (matrix[row][mid] > target){
                end = mid - 1;
            } else if (matrix[row][mid] < target){
                beg = mid + 1;
            }
        }
        return false;
    }
}

