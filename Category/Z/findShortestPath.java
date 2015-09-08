import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {
    public int[][] find(int[][] data) {

        int[][] res = new int[data.length][data[0].length];
        for(int i = 0 ; i < data.length; i++){
            res[i] = new int[data[0].length];
            for(int j = 0 ; j < res[i].length; j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0 ; i < data.length; i++){
            for(int j = 0; j < data[0].length; j++){
                if(data[i][j] == 1){
                    bfs(data, res, i, j);
                }
                if(data[i][j] == 2){
                    res[i][j] = 0;
                }
            }
        }

        for(int i = 0 ; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                if(res[i][j] == Integer.MAX_VALUE){
                    res[i][j] = -1;
                }
            }
        }
        return res;
    }

    public void bfs(int[][] data, int[][] res, int i, int j){
        Queue<Integer> row = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        boolean[][] rec = new boolean[data.length][data[0].length];
        row.offer(i);
        col.offer(j);
        int cur = 1; int next = 0; int level = 0;
        while(!row.isEmpty() && !col.isEmpty()){
            int m = row.poll();
            int n = col.poll();
            cur--;
            if(m - 1 >= 0 && data[m - 1][n] == 1 && !rec[m - 1][n]){
                row.offer(m - 1);
                col.offer(n);
                next++;
            }
            if(m + 1 < data.length && data[m + 1][n] == 1 && !rec[m + 1][n]){
                row.offer(m + 1);
                col.offer(n);
                next++;
            }
            if(n - 1 >= 0 && data[m][n - 1] == 1 && !rec[m][n - 1]){
                row.offer(m);
                col.offer(n - 1);
                next++;
            }
            if(n + 1 < data[0].length && data[m][n + 1] == 2 ){
                row.offer(m);
                col.offer(n + 1);
                next++;
            }

            if(m - 1 >= 0 && data[m - 1][n] == 2){
                break;
            }
            if(m + 1 < data.length && data[m + 1][n] == 2){
                break;
            }
            if(n - 1 >= 0 && data[m][n - 1] == 2){
                break;
            }
            if(n + 1 < data[0].length && data[m][n + 1] == 2){
                break;
            }

            rec[m][n] = true;

            if(cur == 0){
                level++;
                cur = next;
                next = 0;
            }
        }
        res[i][j] = level + 1;
    }

    public static void main(String[] args) {
        //find shortest path from 1 to 2
        int[][] data1 = {
                {1, 2, 1},
                {1, 0, 1},
                {1, 2, 1},
        };
        /*
        [[1, 0, 1]]
        [[2, -1, 2]]
        [[1, 0, 1]]
         */
        
        int[][] res = new Solution().find(data1);
        for(int[] e: res){
            for(int v: e){
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
}
