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
        int len = triangle.size();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[len - 1][i] = triangle.get(triangle.size() - 1).get(i);
        }
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        int[] dp = new int[triangle.size()];
        for(int i = dp.length - 1; i >= 0; i--){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >=0 ; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        int[] dp = new int[triangle.size()];
        for(int i = dp.length - 1; i >= 0; i--){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >=0 ; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}

