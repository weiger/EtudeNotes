import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;

public class Solution {

    static int maxThreats(int[] a) {
        if (a == null || a.length == 0) {
            return 0;
        }
        int[] threats = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            int row = i;
            int col = a[i];
            int count = 0;
            boolean dir1 = false;
            boolean dir2 = false;
            for (int j = i - 1; j >= 0; j--) {
                if (count == 4) {
                    return 4;
                }
                int old_row = j;
                int old_col = a[j];
                if (Math.abs(row - old_row) == Math.abs(col - old_col)) {
                    if (col > old_col && !dir1) {
                        count++;
                        threats[j]++;
                        dir1 = true;
                    }
                    if (col < old_col && !dir2) {
                        count++;
                        threats[j]++;
                        dir2 = true;
                    }
                    if (threats[j] == 4) {
                        return 4;
                    }
                }
            }
            threats[i] = count;
            if (count == 4) {
                return 4;
            }
        }
        int res = 0;
        for (Integer in : threats) {
            res = Math.max(res, in);
        }
        return res;
    }

    /* static int maxThreats2(int[] a) {
        int[] A = new int[a.length + 1];
        int idx = 1;
        for (int x : a) {
            A[idx++] = x;
        }
        HashMap<Integer, Integer> X = new HashMap<>();
        HashMap<Integer, Integer> Y = new HashMap<>();
        int[] threat = new int[A.length];
        for(int i = 1 ; i < A.length; i++){
            if(X.containsKey(A[i] + i)){
                int nearX = X.get(A[i] + i);
                threat[nearX]++;
                threat[i]++;
                X.put(A[i] + i, i);
            }
            if(Y.containsKey(A[i] - i)){
                int nearY = Y.get(A[i] - i);
                threat[nearY]++;
                threat[i]++;
                Y.put(A[i] - i, i);
            }
            if(!X.containsKey(A[i] + i)){
                X.put(A[i] + i, i);
            }
            if(!Y.containsKey(A[i] - i)){
                Y.put(A[i] - i, i);
            }
        }

        int res = 0;
        for(int x: threat){
            res = Math.max(res, x);
        }
        return res;
    }
    */

    public static void main(String[] args) {
        /*Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int[] arr = new int[N];
        for(int i = 0 ; i < N; i++){
            arr[i] = cin.nextInt();
        }*/
        int[] a = {4, 5, 1, 3, 7, 8, 2, 6};
        System.out.println(maxThreats(a));
    }

}
