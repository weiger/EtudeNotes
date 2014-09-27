/*
http://www.careercup.com/question?id=14946605
You are given a grid of numbers. A snake sequence is made up of adjacent numbers such that for each number, the number on the right or the number below it is +1 or -1 its value. For example, 
1 3 2 6 8 
-9 7 1 -1 2 
1 5 0 1 9 
In this grid, (3, 2, 1, 0, 1) is a snake sequence. 
Given a grid, find the longest snake sequences and their lengths (so there can be multiple snake sequences with the maximum length).

*/
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static void findPath() {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        int[][] matrix = new int[][] { { 2, 3, 4, 5 }, { 4, 5, 6, 6 },
        { 20, 6, 7, 7 }, { 6, 7, 8, 9 } };
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                tmp.add(matrix[i][j]);
                dfs(matrix, res, tmp, i, j);
                if (tmp.size() > maxLen) {
                    res.clear();
                    res.add(new ArrayList<Integer>(tmp));
                    maxLen = tmp.size();
                } else if (tmp.size() == maxLen) {
                    res.add(new ArrayList<Integer>(tmp));
                }
                tmp = new ArrayList<Integer>();
            }
        }
        System.out.println(res.toString());
    }

    private static int maxLen = 0;

    private static void dfs(int[][] matrix, List<List<Integer>> res,
        List<Integer> tmp, int i, int j) {
        if ((i >= matrix.length || j >= matrix[0].length)
            || (!(i + 1 < matrix.length && Math.abs(matrix[i][j]
                - matrix[i + 1][j]) == 1) && !(j + 1 < matrix[0].length && Math
            .abs(matrix[i][j] - matrix[i][j + 1]) == 1))) {
            if (tmp.size() < maxLen) {
                return;
            } else if (tmp.size() > maxLen) {
                res.clear();
                maxLen = tmp.size();
            }
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
    // down
        if (i + 1 < matrix.length
            && Math.abs(matrix[i][j] - matrix[i + 1][j]) == 1) {
            tmp.add(matrix[i + 1][j]);
        dfs(matrix, res, tmp, i + 1, j);
        tmp.remove(tmp.size() - 1);
    }
    // right
    if (j + 1 < matrix[0].length
        && Math.abs(matrix[i][j] - matrix[i][j + 1]) == 1) {
        tmp.add(matrix[i][j + 1]);
    dfs(matrix, res, tmp, i, j + 1);
    tmp.remove(tmp.size() - 1);
    }
}

public static void main(String[] args) {
    findPath();
    }
}
