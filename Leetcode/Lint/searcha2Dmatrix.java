/*Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:
Integers in each row are sorted from left to right.
he first integer of each row is greater than the last integer of the previous row.
Example
Consider the following matrix:
[
  [1, 3, 5, 7],

  [10, 11, 16, 20],

  [23, 30, 34, 50]
]
Given target = 3, return true.
Challenge
O(log(n) + log(m)) time
*/

public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if(matrix == null || matrix.size() == 0)
            return false;
        if(target < matrix.get(0).get(0))
            return false;
        int beg = 0;
        int end = matrix.size() - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(matrix.get(mid).get(0) == target)
                return true;
            else if(matrix.get(mid).get(0) < target)
                beg = mid + 1;
            else
                end = mid - 1;
        }
        int c = end;
        beg = end;
        end = matrix.get(beg).size() - 1;
        while(beg <= end){
            int mid = beg + (end - beg)/2;
            if(matrix.get(c).get(mid) == target){
                return true;
            }else if(matrix.get(c).get(mid) < target){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}

