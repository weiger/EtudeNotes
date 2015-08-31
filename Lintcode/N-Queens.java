import java.io.*;
import java.util.*;

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        int[] chess = new int[n];
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        dfs(res, chess, n, 0);
        return res;
    }

    public void dfs(ArrayList<ArrayList<String>> res, int[] chess, int n, int deep){
        if(deep == n){
            store(res, chess, n);
            return;
        }

        for(int i = 0 ; i < n; i++){
            chess[deep] = i;
            if(isValid(chess, deep)){
                dfs(res, chess, n, deep + 1);
            }
        }
    }

    public void store(ArrayList<ArrayList<String>> res, int[] chess, int n){
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            String str = "";
            for(int j = 0; j < n; j++){
                if(chess[i] != j){
                    str += ".";
                }else{
                    str += "Q";
                }
            }
            list.add(str);
        }
        res.add(list);
    }

    public boolean isValid(int[] chess, int deep){
        for(int i = 0 ; i < deep; i++){
            if(chess[deep] == chess[i] || Math.abs(deep - i) == Math.abs(chess[deep] - chess[i])){
                return false;
            }
        }
        return true;
    }
};
