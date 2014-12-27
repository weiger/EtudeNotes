/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:
Integers in each row are sorted from left to right.
Integers in each column are sorted from up to bottom.
No duplicate integers in each row or column.

Example
Consider the following matrix:

[
  [1, 3, 5, 7],
  [2, 4, 7, 8],
  [3, 5, 9, 10]
]
Given target = 3, return 2.
Challenge
O(m+n) time and O(1) extra space
*/
//brute force can be accepted
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        if(matrix == null || matrix.size() == 0)
            return 0;
        int m = matrix.size();
        int n = matrix.get(0).size();
        int cnt = 0;
        for(int x = 0,y = n - 1; x < m && y >=0 ;){
            if(matrix.get(x).get(y) == target ){
                cnt++;
                y--;
            }else if(matrix.get(x).get(y) > target ){
                y--;
            }else if(matrix.get(x).get(y) < target){
                x++;
            }
        }
        return cnt;
    }
}

