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
        if(triangle == null || triangle.size() == 0)
            return 0;
        int[] dp = new int[triangle.get(triangle.size() - 1).size()]; 
        for(int i = 0; i < dp.length; i++){
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for(int i = triangle.size() - 2; i >=0 ; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j + 1]);
            }
        }
        return dp[0];
    }
}

 public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size()];
        for(int i=0;i<triangle.get(triangle.size()-1).size();i++){
            dp[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2;i>=0;i--){    
            for(int j=0;j<triangle.get(i+1).size()-1;j++){  //boundary!!
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
 
 
 
import java.util.*;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][];
        for(int i = 0; i < row; i++) 
            dp[i] = new int[i + 1];
        for(int i = 0; i < row; i++)
            dp[row - 1][i] = triangle.get(row - 1).get(i);
        for(int i = row - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++)
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }
        return dp[0][0];
    }
}
