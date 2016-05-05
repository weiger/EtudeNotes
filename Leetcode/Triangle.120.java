/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move 
 * to adjacent numbers on the row below.

 * For example, given the following triangle

 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total 
 * number of rows in the triangle.
 */
 /*be careful direction of updating
[2],
[3,4],
[6,5,7],
[4,1,8,3]
from bottom to up, dp initialize with last row
from left to right !!!
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() ==0) {
            return 0;
        }
        int[] res = new int[triangle.size()];
        for (int i = 0; i < triangle.get(triangle.size() - 1).size(); i++) {
            res[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i-- ) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[j] = Math.min(res[j], res[j + 1]) + triangle.get(i).get(j); 
            }
        }
        return res[0];
    }
}

