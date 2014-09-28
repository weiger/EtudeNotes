/*
http://blog.csdn.net/wcyoot/article/details/6428305
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> stat(int n) {
        List<Integer> res = new ArrayList<>();
        int[] buf = new int[n];
        for (int i = 0; i < buf.length; i++)
            buf[i] = 0;
        helper(res, buf, n, 0, 0);
        return res;
    }

    public static void helper(List<Integer> res, int[] buf, int n, int deep,
        int sum) {
        if (deep == n) {
            if (isvalid(buf, 0)) {
                for (int x : buf)
                    res.add(x);
            }
            return;
        }
        for (int i = 0; i < n - sum + 1; i++) {
            buf[deep] = i;
            sum = sum + i;
            helper(res, buf, n, deep + 1, sum);
            sum = sum - i;
        }
    }

    public static boolean isvalid(int[] A, int deep) {
        if (deep == A.length)
            return true;
        int j = 0;
        int i = 0;
        while (i < A.length) {
            if (A[i] == deep)
                j++;
            i++;
        }
        if (j == A[deep])
            return isvalid(A, deep + 1);
        else
            return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> res = (ArrayList<Integer>) stat(10);
        System.out.println(res);
    }
}

