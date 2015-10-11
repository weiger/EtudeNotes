import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    public static void findPairs(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < A.length; i++) {
            for (int j = 0 ; j < A[0].length; j++) {
                if (map.containsKey(A[i][j])) {
                    map.put(A[i][j], map.get(A[i][j]) + 1);
                } else {
                    map.put(A[i][j], 1);
                }
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) % 2 == 0) {
                System.out.print(key + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {1,2,3,2},{5,6,7,6},{10,10,11,12},{13,14,15,16}
        };
        findPairs(A);
    }
}
